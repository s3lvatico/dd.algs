package org.gmnz.ddi.algs;

import java.util.Scanner;

public class GraphFactory {

   public static Graph createGraph(Scanner s) {
      int vertexes = s.nextInt();
      BasicGraph g = new BasicGraph(vertexes);
      int edges = s.nextInt();
      for (int i = 0; i < edges; i++) {
         int v1 = s.nextInt();
         int v2 = s.nextInt();
         g.addEdge(v1, v2);
      }
      return g;
   }

}