/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;

import org.apache.commons.math3.ml.clustering.Clusterable;

/**
 *
 * @author MONICA
 */
public class Data implements Clusterable {

    private String id;
    private double[] points;
    private int[] colNos;
/**
 * 
 * @param id
 * @param points
 * @param colNos 
 */
    public Data(String id, double[] points, int... colNos) {
        this.id = id;
        this.points = points;
        if (colNos.length > points.length) {
            throw new IllegalArgumentException();
        }
        this.colNos = colNos;
    }
    
    /**
     *digunakan ketika clustering untuk mengelompokkan atributnya 
     * @return 
     */
        public double[] getPoint() {
        double[] pts = new double[colNos.length];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = points[colNos[i]];
        }
        return pts;
    }

    @Override
    public String toString() {
        String res = id;
        res += ": [";
        for (int i = 0; i < getPoint().length; i++) {
            double d = getPoint()[i];
            res += d;
            if (i < getPoint().length - 1) {
                res += ", ";
            }
        }
        res += "]";
        System.out.println("");
        return res;
    }
}
