package org.gmnz.hr;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class CastleOnTheGrid {

   static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

      return -1;
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

/*
 * 
 * "type": "java", "name": "CodeLens (Launch) - CastleOnTheGrid", "request":
 * "launch", "mainClass": "org.gmnz.hr.CastleOnTheGrid", "projectName":
 * "hackerrank", "env": { "OUTPUT_PATH":
 * "C:\\dev\\src\\dd.algs\\hackerrank\\resources\\q.txt" }, "args":
 * "< C:\\dev\\src\\dd.algs\\hackerrank\\target\\classes\\castleOnTheGrid-in01.txt"
 * },
 * 
 */