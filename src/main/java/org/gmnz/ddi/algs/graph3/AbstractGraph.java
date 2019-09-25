package org.gmnz.ddi.algs.graph3;


import java.util.Scanner;


abstract class AbstractGraph implements Graph {

    protected int V;

    public AbstractGraph(int nVertexes) {
        this.V = nVertexes;
    }



    public AbstractGraph(Scanner s) {
        // TODO eventualmente da fare
    }
}