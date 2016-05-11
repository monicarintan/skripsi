/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;

import java.util.ArrayList;
import static java.util.Collections.max;
import static java.util.Collections.min;
import java.util.List;

/**
 *
 * @author MONICA
 */
public class Cluster implements Clusterable {

    private Method method;

    private static double avg(List<Double> dists) {
        double sum = 0;
        for (double d : dists) {
            sum += d;
        }
        return sum / ((double) dists.size());
    }

    public enum Method {

        SINGLE_LINKAGE, COMPLETE_LINKAGE, AVERAGE_LINKAGE
    }

    public Cluster(Method method) {
        this.method = method;
        points = new ArrayList<>();
    }

    private final List<Clusterable> points;

    public void addPoint(Clusterable point) {
        points.add(point);
    }

    @Override
    public double[] getPoint() {
        return null;
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
    @Override
    public double distanceTo(Clusterable other) {
        List<Double> dists = new ArrayList<>();
        for (Clusterable cl : points) {
            if (other instanceof Cluster) {
                Cluster c = (Cluster) other;
                for (Clusterable cls : c.getAllPoints()) {
                    double dist = cl.distanceTo(cls);
                    if (!dists.contains(dist)) {
                        dists.add(dist);
                    }
                }
            } else {
                double dist = cl.distanceTo(other);
                if (!dists.contains(dist)) {
                    dists.add(dist);
                }
            }
        }
        switch (method) {
            case SINGLE_LINKAGE:
                return min(dists);
            case COMPLETE_LINKAGE:
                return max(dists);
            default:
                return avg(dists);
        }
    }

    public List<Clusterable> getAllPoints() {
        List<Clusterable> result = new ArrayList<>();
        for (Clusterable c : points) {
            if (c instanceof Data) {
                result.add(c);
            } else if (c instanceof Cluster) {
                for (Clusterable c1 : ((Cluster) c).getAllPoints()) {
                    result.add(c1);
                }
            }
        }
        return result;
    }
}
