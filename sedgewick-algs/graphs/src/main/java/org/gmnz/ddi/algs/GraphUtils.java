package org.gmnz.ddi.algs;


import java.util.concurrent.atomic.AtomicInteger;


public class GraphUtils {

   public static int degree(Graph g, int v) {
      AtomicInteger ai = new AtomicInteger(0);
      g.adj(v).forEach(w -> ai.incrementAndGet());
      return ai.get();
   }



   public static int maxDegree(Graph g) {
      int maxDegree = 0;
      for (int v = 0; v < g.V(); v++) {
         int degG = degree(g, v);
         if (degG > maxDegree)
            maxDegree = degG;
      }
      return maxDegree;
   }

}