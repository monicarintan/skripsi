/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ahc.algorithm;

/**
 *
 * @author MONICA
 */
public class EuclideanDistance implements DistanceMeasure {

    @Override
    public double compute(double[] arg0, double[] arg1) {
        
        double jumlah =0;
        for (int i = 0; i < arg0.length; i++) {
                jumlah = jumlah+ Math.pow(arg0[i]-arg1[i],2);
        }
        return Math.sqrt(jumlah);  
    }
}
