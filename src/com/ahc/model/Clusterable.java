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
public interface Clusterable {
     double[] getPoint();
     double distanceTo(Clusterable other);
}
