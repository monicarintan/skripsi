/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;
import static java.util.Collections.min;

/**
 * @author MONICA
 */
public class Cluster {

    private static int number = 1;
//    private final Method method;
    private String method;
    private final Cluster[] clusters = new Cluster[2];
    private String id;
    private Point point;
    private Cluster parent;

    public boolean isPoint() {
        return point != null;
    }

    public String getId() {
        return id;
    }

    public Cluster getParent() {
        return parent;
    }

    public void setParent(Cluster parent) {
        this.parent = parent;
    }

    public Cluster getPoint(int index) {
        return clusters[index];
    }

    public Cluster[] getClusters() {
        return clusters;
    }

//    public Cluster(Method method, Pair points) {
//        this.method = method;
//        this.clusters[0] = points.getLeft();
//        this.clusters[1] = points.getRight();
//    }
    
    public Cluster(String method, Pair points) {
        this.method = method;
        this.clusters[0] = points.getLeft();
        this.clusters[1] = points.getRight();
    }

    /**
     *
     * @param method
     * @param point
     */
//    public Cluster(Method method, Point point) {
//        this.method = method;
//        this.point = point;
//    }
    public Cluster(String method, Point point) {
        this.method = method;
        this.point = point;
    }

    private static double avg(List<Double> dists) {
        double sum = 0;
        for (double d : dists) {
            sum += d;
        }
        return sum / ((double) dists.size());
    }

    //    private static double min(List<Double> dists) {
//        double min = dists.get(0);
//        for (double i : dists) {
//            if (i < min) {
//                min = i;
//            }
//        }
//        return min;
//    }
    
    public double distanceTo(Cluster other) {
        List<Double> dists = new ArrayList<>();
//list baru buat nampung daftar jaraknya
        if (isPoint()) {
            if (other.isPoint()) { // point ke point
                double[] p1 = getValues();
                double[] p2 = other.getValues();
                double sum = 0;
                for (int i = 0; i < p1.length; i++) {
                    sum += (p1[i] - p2[i]) * (p1[i] - p2[i]);
                }
                return sqrt(sum);
            } else { // point ke cluster
                return other.distanceTo(this);
            }
        } else {
            if (other.isPoint()) { //  cluster ke point
                for (Point p : getAllPoints()) {
                    double[] p1 = p.getValues();
                    double[] p2 = other.getValues();
                    double sum = 0;
                    for (int i = 0; i < p1.length; i++) {
                        sum += (p1[i] - p2[i]) * (p1[i] - p2[i]);
                    }
                    double dist = sqrt(sum);
                    if (!dists.contains(dist)) {
                        dists.add(dist);
                    }
                }
            } else { // cluster ke cluster
                for (Point p : getAllPoints()) {
                    for (Point ps : other.getAllPoints()) {
                        double[] p1 = p.getValues();
                        double[] p2 = ps.getValues();
                        double sum = 0;
                        for (int i = 0; i < p1.length; i++) {
                            sum += (p1[i] - p2[i]) * (p1[i] - p2[i]);
                        }
                        double dist = sqrt(sum);
                        if (!dists.contains(dist)) {
                            dists.add(dist);
                        }
                    }
                }
            }
        }
//        switch (method) {
//            case SINGLE_LINKAGE:
//                return min(dists);
//            case COMPLETE_LINKAGE:
//                return max(dists);
//            default:
//                return avg(dists);
//        }
        switch (method) {
            case "SINGLE_LINKAGE":
                return min(dists);
            case "COMPLETE_LINKAGE":
                return max(dists);
            default:
                return avg(dists);
        }
    }

    public double[] getValues() { 
        return point == null ? null : point.getValues();
    }
    
// untuk dapetin point2 yg didalemnya

    public List<Point> getAllPoints() {
        List<Point> result = new ArrayList<>();
        if (isPoint()) {
            result.add(point);
            return result;
        }
        for (Cluster c : clusters) {
            if (c != null) {
                result.addAll(c.getAllPoints());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return getAllPoints().toString();
    }

//    public enum Method {
//
//        SINGLE_LINKAGE, COMPLETE_LINKAGE, AVERAGE_LINKAGE
//    }
}
