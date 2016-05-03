/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ahc.model;

import java.util.List;

/**
 * 
 * @author MONICA
 */
public class Cluster {
    public List<DistanceMatrix> dm;
    public double singleLinkageDistance(Cluster other) {
      double shortestDistance = Double.MIN_VALUE;

      for (DistanceMatrix item : dm ) {
         for (DistanceMatrix otherItem : other.dm) {
            double distance = item.getDistance(item, otherItem);
            if (distance < shortestDistance) {
               shortestDistance = distance;
            }
         }
      }

      return shortestDistance;
   }
}
