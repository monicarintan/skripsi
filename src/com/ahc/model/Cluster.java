/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;
import static java.util.Collections.min;

/**
 * @author MONICA
 */
public class Cluster extends Point {

    private final Method method;
    private final Point[] points = new Point[2];
    private String id;

    public Point getPoint(int index) {
        return points[index];
    }

    public Point[] getPoints() {
        return points;
    }

    public Cluster(Method method) {
        this.method = method;
    }

    private static double avg(List<Double> dists) {
        double sum = 0;
        for (double d : dists) {
            sum += d;
        }
        return sum / ((double) dists.size());
    }

    public void addPoint(Point point) {
        if (points[0] == null) {
            points[0] = point;
        } else if (points[1] == null) {
            points[1] = point;
        } else {
            throw new IllegalArgumentException("already clustered");
        }
//        points.add(point);
    }

    @Override
    public double[] getValues() {
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
    public double distanceTo(Point other) {
        List<Double> dists = new ArrayList<>();
        for (Point cl : points) {
            if (other instanceof Cluster) {
                for (Point cls : ((Cluster) other).getAllPoints()) {
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

    public List<Point> getAllPoints() {
        List<Point> result = new ArrayList<>();
        for (Point c : points) {
            if (c instanceof Cluster) {
                for (Point c1 : ((Cluster) c).getAllPoints()) {
                    if (!result.contains(c1)) {
                        result.add(c1);
                    }
                }
            } else {
                if (!result.contains(c)) {
                    result.add(c);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return getAllPoints().toString();
    }

    public enum Method {

        SINGLE_LINKAGE, COMPLETE_LINKAGE, AVERAGE_LINKAGE
    }
}
