/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.algorithm;

import com.ahc.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MONICA
 */
public class AgglomerativeClusterer {

    private final com.ahc.model.Cluster.Method method;
    private final DistanceMeasure measure;

    public AgglomerativeClusterer(DistanceMeasure measure, com.ahc.model.Cluster.Method method) {
        this.measure = (measure);
        this.method = method;
    }

    public ClusterTree cluster(List<? extends Point> points) {
        ArrayList<Point> unclusteredPoints = new ArrayList<>(points);
        while (unclusteredPoints.size() > 1) {
            DistanceMatrix matrix = new DistanceMatrix(new EuclideanDistance());
            matrix.computeAll(unclusteredPoints);
            Pair min = matrix.getMinimumDistance().getKey();
            Cluster c = new Cluster(Cluster.Method.SINGLE_LINKAGE);
            c.addPoint(min.getLeft());
            c.addPoint(min.getRight());
            unclusteredPoints.remove(min.getLeft());
            unclusteredPoints.remove(min.getRight());
            unclusteredPoints.add(c);
        }
        return new ClusterTree((Cluster) unclusteredPoints.get(0));
    }

}
