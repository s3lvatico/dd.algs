package org.gmnz.hr;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CastleOnTheGrid {

   private static int size;

   static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

      if ((startX == goalX && startY == goalY) || grid.length == 1)
         return 0; // caso banale

      // --- SETUP

      size = grid.length;

      StringBuilder sbGrid = new StringBuilder();
      for (String line : grid)
         sbGrid.append(line);

      String linearGrid = sbGrid.toString();

      int[] moves = new int[linearGrid.length()];
      Arrays.fill(moves, -1);

      // int[] edgeTo = new int[linearGrid.length()];

      int startCell = cell(startY, startX);
      int goalCell = cell(goalY, goalX);

      ArrayDeque<Integer> q = new ArrayDeque<>();

      // --- BFS
      boolean goalReached = false;
      moves[startCell] = 0;
      q.add(startCell);

      while (!q.isEmpty() && !goalReached) {
         int v = q.poll();
         // if (v == goalCell) {
         //    goalReached = true;
         //    continue;
         // }
         for (RunningVertex va : adjacencies(linearGrid, v)) {
            RunningVertex vs = va;
            while (vs != null) {
               if (vs.id == goalCell) {
                  goalReached = true;
                  return moves[v] + 1;
               }
               if (moves[vs.id] < 0) {// marked == false
                  moves[vs.id] = moves[v] + 1;
                  q.offer(vs.id);
               }
               vs = nextVertex(vs, linearGrid);
            }

         }
      }

      if (!goalReached)
         return -1;

      return -1;
   }



   private static RunningVertex nextVertex(RunningVertex v, String linearGrid) {
      switch (v.direction) {
      case N:
         if (v.id >= size && linearGrid.charAt(v.id - size) != 'X') {
            return new RunningVertex(v.id - size, Direction.N);
         } else
            return null;
      case W:
         if (v.id % size > 0 && linearGrid.charAt(v.id - 1) != 'X') {
            return new RunningVertex(v.id - 1, Direction.W);
         } else
            return null;
      case S:
         if (v.id < linearGrid.length() - size && linearGrid.charAt(v.id + size) != 'X') {
            return new RunningVertex(v.id + size, Direction.S);
         } else
            return null;
      case E:
         if (v.id % size != size - 1 && linearGrid.charAt(v.id + 1) != 'X') {
            return new RunningVertex(v.id + 1, Direction.E);
         } else
            return null;
      default:
         throw new RuntimeException();
      }
   }



   private static int cell(int x, int y) {
      return x + size * y;
   }



   private static RunningVertex[] adjacencies(String linearGrid, int id) {
      ArrayList<RunningVertex> adj = new ArrayList<>();

      // cella a nord: non esiste se sto sul bordo superiore
      if (id >= size && linearGrid.charAt(id - size) != 'X') {
         adj.add(new RunningVertex(id - size, Direction.N));
      }
      // cella a est: non esiste se sto sul bordo destro
      if (id % size != size - 1 && linearGrid.charAt(id + 1) != 'X') {
         adj.add(new RunningVertex(id + 1, Direction.E));
      }
      // cella a sud: non esiste se sto sul bordo inferiore
      if (id < linearGrid.length() - size && linearGrid.charAt(id + size) != 'X') {
         adj.add(new RunningVertex(id + size, Direction.S));
      }
      // cella a ovest: non esiste se sto sul bordo sinistro
      if (id % size > 0 && linearGrid.charAt(id - 1) != 'X') {
         adj.add(new RunningVertex(id - 1, Direction.W));
      }

      return adj.toArray(new RunningVertex[] {});
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      String[] grid = new String[n];

      for (int i = 0; i < n; i++) {
         String gridItem = scanner.nextLine();
         grid[i] = gridItem;
      }

      String[] startXStartY = scanner.nextLine().split(" ");

      int startX = Integer.parseInt(startXStartY[0]);

      int startY = Integer.parseInt(startXStartY[1]);

      int goalX = Integer.parseInt(startXStartY[2]);

      int goalY = Integer.parseInt(startXStartY[3]);

      int result = minimumMoves(grid, startX, startY, goalX, goalY);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
   }
}





enum Direction {
   N, W, S, E;
}





class RunningVertex {

   RunningVertex(int id, Direction direction) {
      this.id = id;
      this.direction = direction;
   }
   int id;
   Direction direction;
}