package com.ahc.model;

/**
 * Created by ric on 13/05/16.
 */
public class ClusterTree {
    private final Cluster root;

    @Override
    public String toString() {
        if(root==null) return "null";
        return root.toString();
    }

    public ClusterTree(Cluster root) {
        this.root = root;
    }
}
