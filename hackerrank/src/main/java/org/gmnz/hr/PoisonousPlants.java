package org.gmnz.hr;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class PoisonousPlants {

   // Complete the poisonousPlants function below.
   static int poisonousPlants(Deque<Integer> q) {

      int daysPassed = 0;
      int survivedPlants = q.size();
      while (q.size() > 0) {
         LinkedList<Integer> q2 = new LinkedList<>();
         int x = q.poll();
         if (q.peek() != null && x <= q.peek()) {
            q2.offerLast(x);
         }
      }
      return -1;
   }

   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] p = new int[n];

      String[] pItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
         int pItem = Integer.parseInt(pItems[i]);
         p[i] = pItem;
      }

      Deque<Integer> q = new LinkedList<>();
      Arrays.stream(p).forEach(q::addLast);

      int result = poisonousPlants(q);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();

      scanner.close();
   }
}