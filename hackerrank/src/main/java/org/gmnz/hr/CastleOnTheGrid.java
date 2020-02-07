package org.gmnz.hr;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;


public class CastleOnTheGrid {

   static final int[] X_OFFSETS = { -1, 0, 1, 0 };
   static final int[] Y_OFFSETS = { 0, 1, 0, -1 };

   static int minimumMoves(String[] strings, int startX, int startY, int goalX, int goalY) {

      int size = strings.length;
      char[][] grid = new char[size][size];
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            grid[i][j] = strings[i].charAt(j);
         }
      }

      int[][] moves = new int[size][size];
      // IntStream.range(0, size).forEach(x -> Arrays.fill(moves[x], -1));
      for (int[] row : moves) {
         Arrays.fill(row, -1);
      }

      moves[startX][startY] = 0;
      Queue<Point> queue = new LinkedList<>();
      queue.offer(new Point(startX, startY));

      while (true) {
         Point head = queue.poll();
         for (int i = 0; i < X_OFFSETS.length; i++) {
            int nextX = head.x;
            int nextY = head.y;

            while (isOpen(grid, nextX + X_OFFSETS[i], nextY + Y_OFFSETS[i])) {
               nextX += X_OFFSETS[i];
               nextY += Y_OFFSETS[i];

               if (nextX == goalX && nextY == goalY) {
                  return moves[head.x][head.y] + 1;
               }

               if (moves[nextX][nextY] < 0) {
                  moves[nextX][nextY] = moves[head.x][head.y] + 1;
                  queue.offer(new Point(nextX, nextY));
               }
            }
         }
      }
   }



   static boolean isOpen(char[][] grid, int x, int y) {
      return x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == '.';
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






class Point {
   int x;
   int y;

   Point(int x, int y) {
      this.x = x;
      this.y = y;
   }



   @Override
   public String toString() {
      return String.format("Point [x=%d, y=%d]", x, y);
   }
}
