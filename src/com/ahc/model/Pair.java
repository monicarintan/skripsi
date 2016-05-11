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
public class Pair {

    private Clusterable element0;
    private Clusterable element1;

    public Pair(Clusterable element0, Clusterable element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public Clusterable getLeft() {
        return element0;
    }

    public Clusterable getRight() {
        return element1;
    }

    @Override
    public String toString() {
        return element0.toString() + "," + element1.toString();
    }

    @Override
    public boolean equals(Object P) {
        if (P == null) {
            return false;
        }
        if (!(P instanceof Pair)) {
            return false;
        }
        Pair p = (Pair) P;
        return (element0.equals(p.element0) && element1.equals(p.element1))
                || (element1.equals(p.element0) && element0.equals(p.element1));
    }
}
