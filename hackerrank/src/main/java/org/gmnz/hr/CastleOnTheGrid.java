package org.gmnz.hr;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CastleOnTheGrid {


   static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

      if ((startX == goalX && startY == goalY) || grid.length == 1)
         return 0; // caso banale


      // --- SETUP

      StringBuilder sbGrid = new StringBuilder();
      for (String line : grid)
         sbGrid.append(line);

      String linearGrid = sbGrid.toString();

      boolean[] marked = new boolean[linearGrid.length()];
      Arrays.fill(marked, false);

      int[] edgeTo = new int[linearGrid.length()];

      int startCell = cell(grid.length, startX, startY);
      int goalCell = cell(grid.length, goalX, goalY);

      ArrayDeque<Integer> q = new ArrayDeque<>();


      // --- BFS
      boolean goalReached = false;
      marked[startCell] = true;
      q.add(startCell);

      while (!q.isEmpty() && !goalReached) {
         int v = q.poll();
         if (v == goalCell) {
            goalReached = true;
            continue;
         }
         for (int w : adjacencies(linearGrid, grid.length, v)) {
            if (!marked[w]) {
               edgeTo[w] = v;
               marked[w] = true;
               q.add(w);
            }
         }
      }

      if (!goalReached)
         return -1;

      // altrimenti vediamo come calcolare bene il numero delle mosse

      int nMoves = 1;
      int x = goalCell;
      int y = edgeTo[x];
      int currentDirection = getDirection(x, y, grid.length);
      while (y != startCell) {
         x = y;
         y = edgeTo[x];
         int direction = getDirection(x, y, grid.length);
         if ( direction != currentDirection) {
            nMoves++;
            currentDirection = direction;
         }
      }

      return nMoves;
   }



   private static int getDirection(int x, int y, int n) {
      if (Math.abs(x - y) == n)
         return 1;
      else
         if (Math.abs(x - y) < n)
            return -1;
         else // anche se viste le ipotesi non dovrebbe verificarsi
            return 0;
   }



   private static int cell(int l, int x, int y) {
      return x + l * y;
   }



   private static int[] adjacencies(String lg, int n, int id) {
      ArrayList<Integer> adj = new ArrayList<>();

      // cella a nord: non esiste se sto sul bordo superiore
      if (id >= n && lg.charAt(id - n) != 'X') {
         adj.add(id - n);
      }
      // cella a est: non esiste se sto sul bordo destro
      if (id % n != n - 1 && lg.charAt(id + 1) != 'X') {
         adj.add(id + 1);
      }
      // cella a sud: non esiste se sto sul bordo inferiore
      if (id < lg.length() - n && lg.charAt(id + n) != 'X') {
         adj.add(id + n);
      }
      // cella a ovest: non esiste se sto sul bordo sinistro
      if (id % n > 0 && lg.charAt(id - 1) != 'X') {
         adj.add(id - 1);
      }

      int[] arr = new int[adj.size()];
      int count = 0;
      for (Integer i : adj) {
         arr[count++] = i;
      }

      // return adj.stream().mapToInt(x -> x.intValue()).toArray();
      return arr;
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
