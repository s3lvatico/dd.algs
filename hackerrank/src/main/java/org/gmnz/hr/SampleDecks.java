package org.gmnz.hr;


import java.util.Deque;
import java.util.LinkedList;


public class SampleDecks {

   public static void main(String[] args) {
      Deque<Integer> q = new LinkedList<>();

      q.offer(1);
      q.offer(2);
      q.offer(3);

      q.offerFirst(18);

      System.out.println(q);

      System.out.println(q.poll());
      System.out.println(q.poll());
      System.out.println(q.poll());
      System.out.println(q.poll());
      System.out.println(q.poll());
      q.clear();
      q.offerLast(1);
      q.offerLast(2);
      q.offerLast(3);
      System.out.println(q);

   }

}