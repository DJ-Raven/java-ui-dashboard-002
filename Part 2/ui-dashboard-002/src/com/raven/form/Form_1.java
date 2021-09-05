package com.raven.form;

import com.raven.chart.ModelChartLine;
import com.raven.chart.ModelChartPie;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Form_1 extends javax.swing.JPanel {

    public Form_1() {
        initComponents();
        initData();
    }

    private void initData() {
        List<ModelChartPie> list1 = new ArrayList<>();
        list1.add(new ModelChartPie("Monday", 10, new Color(4, 174, 243)));
        list1.add(new ModelChartPie("Tuesday", 150, new Color(215, 39, 250)));
        list1.add(new ModelChartPie("Wednesday", 80, new Color(44, 88, 236)));
        list1.add(new ModelChartPie("Thursday", 100, new Color(21, 202, 87)));
        list1.add(new ModelChartPie("Friday", 125, new Color(127, 63, 255)));
        list1.add(new ModelChartPie("Saturday", 80, new Color(238, 167, 35)));
        list1.add(new ModelChartPie("Sunday", 200, new Color(245, 79, 99)));
        chartPie.setModel(list1);
        //  Test data chart line
        List<ModelChartLine> list = new ArrayList<>();
        list.add(new ModelChartLine("Monday", 10));
        list.add(new ModelChartLine("Tuesday", 150));
        list.add(new ModelChartLine("Wednesday", 80));
        list.add(new ModelChartLine("Thursday", 100));
        list.add(new ModelChartLine("Friday", 125));
        list.add(new ModelChartLine("Saturday", 80));
        list.add(new ModelChartLine("Sunday", 200));
        chartLine1.setModel(list);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartPie = new com.raven.chart.ChartPie();
        chartLine1 = new com.raven.chart.ChartLine();

        setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartLine1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chartPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(286, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.ChartLine chartLine1;
    private com.raven.chart.ChartPie chartPie;
    // End of variables declaration//GEN-END:variables
}
