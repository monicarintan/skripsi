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

    public AgglomerativeClusterer(com.ahc.model.Cluster.Method method) {
        this.method = method;
    }

    public Cluster cluster(List<? extends Point> points) {
        ArrayList<Cluster> unclusteredPoints = new ArrayList<>();
        for (Point p : points) {
            Cluster c = new Cluster(method, p);
            unclusteredPoints.add(c);
        }
        while (unclusteredPoints.size() > 1) {
            DistanceMatrix matrix = new DistanceMatrix();
            matrix.computeAll(unclusteredPoints);
            Pair min = matrix.getMinimumDistance();
            Cluster c = new Cluster(method,min);

            ((Cluster) min.getLeft()).setParent(c);

            ((Cluster) min.getRight()).setParent(c);

            unclusteredPoints.remove(min.getLeft());
            unclusteredPoints.remove(min.getRight());
            unclusteredPoints.add(c);
        }
        return unclusteredPoints.get(0);
    }

}
