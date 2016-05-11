/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.ml.distance.DistanceMeasure;

/**
 *
 * @author MONICA
 */
public class AgglomerativeClusterer {

    private final com.ahc.model.Cluster.Method method;
    private final DistanceMeasure measure;

    public AgglomerativeClusterer(DistanceMeasure measure, com.ahc.model.Cluster.Method method) {
        this.measure = (measure);
        this.method = method;
    }

    public List<? extends Cluster> cluster(List<? extends Point> points) throws MathIllegalArgumentException, ConvergenceException {
        DistanceMatrix matrix = new DistanceMatrix(measure);
        matrix.computeAll(points);
        List<Cluster> result = new ArrayList<>();
        return result;
    }

}
