package org.gmnz.ddi.algs;


import java.util.concurrent.atomic.AtomicInteger;


public class GraphUtils {

   /**
    * grado di un vertice, i.e. il numero di archi che hanno per estremo il vertice
    * dato
    */
   public static int degree(Graph g, int v) {
      AtomicInteger ai = new AtomicInteger(0);
      g.adj(v).forEach(w -> ai.incrementAndGet());
      return ai.get();
   }



   /**
    * grado massimo del grafo
    */
   public static int maxDegree(Graph g) {
      int maxDegree = 0;
      for (int v = 0; v < g.V(); v++) {
         int degG = degree(g, v);
         if (degG > maxDegree)
            maxDegree = degG;
      }
      return maxDegree;
   }



   /**
    * grado medio (dei vertici) del grafo
    */
   public static double averageDegree(Graph g) {
      /*
       * Ragiona: ogni arco ha esattamente due vertici...
       */
      return 2f * g.E() / (double) g.V();
   }



   /**
    * numero di archi che hanno per estremi lo stesso vertice
    */
   public static int numberOfSelfLoops(Graph g) {
      int count = 0;
      for (int i = 0; i < g.V(); i++) {
         for (int w : g.adj(i))
            if (w == i)
               count++;
      }
      return count / 2;
   }



   public static String toString(Graph g) {
      StringBuilder sb = new StringBuilder("Vertices: ");
      sb.append(Integer.toString(g.V())).append(", Edges: ");
      sb.append(Integer.toString(g.E())).append("\n");
      for (int i = 0; i < g.V(); i++) {
         sb.append(i).append(": ");
         for (int w : g.adj(i))
            sb.append(w).append(" ");
         sb.append("\n");
      }
      sb.append("\n");
      return sb.toString();
   }



   public static void printInfo(Graph g) {
      System.out.println("Main graph info");
      System.out.println(toString(g));
      System.out.printf("Maximum vertex degree: %2d, %5sAverage degree: %2.2f%n", maxDegree(g), "", averageDegree(g));
      System.out.printf("Self loops: %2d%n", numberOfSelfLoops(g));
      System.out.print("Vertex degrees: ");
      for (int i = 0; i < g.V(); i++) {
         System.out.printf("%2d[%d]  ", i, degree(g, i));
      }
      System.out.println("\n");
   }
}