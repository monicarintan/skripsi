/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;

import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author ric
 */
public class ClusterTreeModel implements TreeModel {

    private static final Cluster FAKE_ROOT = new Cluster((String)null, (Point) null) {

        @Override
        public String toString() {
            return "";
        }

        @Override
        public boolean isPoint() {
            return false;
        }

    };

    private final Cluster root;
    private final List<Cluster> clusters;

//    public ClusterTreeModel(Cluster c) {
//        cluster = c;
//    }
    public ClusterTreeModel(Cluster c) {
        root = c;
        clusters = null;
    }

    public ClusterTreeModel(List<Cluster> clusters) {
        this.clusters = clusters;
        root = FAKE_ROOT;
    }

    @Override
//    public Object getRoot() {
//        return cluster;
//    }

    public Object getRoot() {
        return root;
    }

    @Override
//    public Object getChild(Object parent, int index) {
//        return ((Cluster) parent).getPoint(index);
//    }

    public Object getChild(Object parent, int index) {
        if (parent == FAKE_ROOT) {
            return clusters.get(index);
        }
        return ((Cluster) parent).getPoint(index);
    }
    
//    public int getChildCount(Object parent) {
//        return ((Cluster) parent).isPoint() ? 0 : 2;
//    }
@Override
    public int getChildCount(Object parent) {
        if (parent == FAKE_ROOT) {
            return clusters.size();
        }
        return ((Cluster) parent).isPoint() ? 0 : 2;
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((Cluster) node).isPoint();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
    }

    @Override
//    public int getIndexOfChild(Object parent, Object child) {
//        if (parent == null || child == null) {
//            return -1;
//        }
//        if (child == ((Cluster) parent).getPoint(0)) {
//            return 0;
//        }
//        if (child == ((Cluster) parent).getPoint(1)) {
//            return 1;
//        }
//        return -1;
//    }

    public int getIndexOfChild(Object parent, Object child) {
        if (parent == null || child == null) {
            return -1;
        }
        if (parent == FAKE_ROOT) {
            return clusters.indexOf(child);
        }
        if (child == ((Cluster) parent).getPoint(0)) {
            return 0;
        }
        if (child == ((Cluster) parent).getPoint(1)) {
            return 1;
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
    }

}
