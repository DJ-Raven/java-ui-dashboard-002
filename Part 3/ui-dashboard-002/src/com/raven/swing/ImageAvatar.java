package com.raven.swing;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImageAvatar extends JComponent {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        updateImage = false;
        repaint();
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        updateImage = false;
        repaint();
    }

    private Icon icon;
    private int borderSize;
    private Image image;

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        if (updateImage == false || (oldWidth != width || oldHeight != height)) {
            createImage();
        }
        if (image != null) {
            grphcs.drawImage(image, 0, 0, null);
        }
        super.paintComponent(grphcs);
    }

    private int oldWidth;
    private int oldHeight;
    private boolean updateImage;

    private void createImage() {
        if (icon != null) {
            int width = getWidth();
            int height = getHeight();
            BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = buff.createGraphics();
            int diameter = Math.min(width, height);
            int x = width / 2 - diameter / 2;
            int y = height / 2 - diameter / 2;
            int border = borderSize * 2;
            diameter -= border;
            Dimension size = getAutoSize(icon, diameter);
            BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2_img = img.createGraphics();
            g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2_img.fillOval(0, 0, diameter, diameter);
            Composite composite = g2_img.getComposite();
            g2_img.setComposite(AlphaComposite.SrcIn);
            g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2_img.drawImage(toImage(icon), 0, 0, size.width, size.height, null);
            g2_img.setComposite(composite);
            g2_img.dispose();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (borderSize > 0) {
                diameter += border;
                g2.setColor(getForeground());
                g2.fillOval(x, y, diameter, diameter);
            }
            if (isOpaque()) {
                g2.setColor(getBackground());
                diameter -= border;
                g2.fillOval(x + borderSize, y + borderSize, diameter, diameter);
            }
            g2.drawImage(img, x + borderSize, y + borderSize, null);
            image = buff;
            oldWidth = width;
            oldHeight = height;
            updateImage = true;
        }
    }

    private Dimension getAutoSize(Icon image, int size) {
        int w = size;
        int h = size;
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / iw;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        return new Dimension(width, height);
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
}
