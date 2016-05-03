/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ahc.model;

import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.clustering.Clusterer;
import org.apache.commons.math3.ml.distance.DistanceMeasure;

/**
 *
 * @author MONICA
 */
public class AgglomerativeClusterer extends Clusterer<Clusterable>{
public AgglomerativeClusterer(DistanceMeasure measure){
    super(measure);
}
    @Override
    public List<? extends Cluster<Clusterable>> cluster(Collection<Clusterable> points) throws MathIllegalArgumentException, ConvergenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
    
}
