/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MONICA
 */
public class ClusterTableModel extends AbstractTableModel {

    private final List<Cluster> clusters;

    public ClusterTableModel(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public int getRowCount() {
        List<Integer> length = new ArrayList<>();
        for (Cluster c : clusters) {
            length.add(c.getAllPoints().size());
        }
        return Collections.max(length);
    }

    @Override
    public int getColumnCount() {
        return clusters.size();
    }

    @Override
    public String getColumnName(int column) {
        return "Cluster #" + (column + 1);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cluster c = clusters.get(columnIndex);
        List<Point> points = c.getAllPoints();
        if (rowIndex >= points.size()) {
            return null;
        }
        return points.get(rowIndex);
    }

}
