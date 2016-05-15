/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;


/**
 *
 * @author MONICA
 */
public class Point {

    private String id;
    private double[] points;
    private int[] colNos;

    public Point() {
    }

    /**
     *
     * @param id
     * @param points
     * @param colNos
     */
    public Point(String id, double[] points, int... colNos) {
        this.id = id;
        this.points = points;
        if (colNos.length > points.length) {
            throw new IllegalArgumentException();
        }
        this.colNos = colNos;
    }

    /**
     * digunakan ketika clustering untuk mengelompokkan atributnya
     *
     * @return
     */
    public double[] getValues() {
        double[] pts = new double[colNos.length];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = points[colNos[i]];
        }
        return pts;
    }

    @Override
    public String toString() {
        String res = id;
        return res;
    }

 
}
