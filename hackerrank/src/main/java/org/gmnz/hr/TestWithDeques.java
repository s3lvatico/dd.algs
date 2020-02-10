package org.gmnz.hr;


import java.io.DataInputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


class TestWithDeques {

    private static int days(int[] p) {
        // 6 5 8 4 7 10 9
        Deque<Integer> dqKo = new LinkedList<>();
        Arrays.stream(p).forEach(dqKo::offer);
        System.out.println(dqKo);

        int daysPassed = 0;

        int size = -1;

        while (size != dqKo.size()) {
            size = dqKo.size();
            Deque<Integer> dqOtsu = new LinkedList<>();
            Integer x = dqKo.pollLast();
            while (x != null) {
                if (dqKo.peekLast() == null || x <= dqKo.peekLast()) {
                    dqOtsu.offerFirst(x);
                }
                x = dqKo.pollLast();
            }
            System.out.println(dqOtsu);
            ++daysPassed;
            dqKo = dqOtsu;
        }

        return daysPassed - 1;
    }



    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.printf("coda dopo l'aggiunta : %s%n", q);

        Integer s1 = q.poll();
        System.out.printf("scodo: %d%n", s1);
        System.out.printf("coda : %s%n", q);
        s1 = q.poll();
        System.out.printf("scodo: %d%n", s1);
        System.out.printf("coda : %s%n", q);
        s1 = q.poll();
        System.out.printf("scodo: %s%n", s1);
        System.out.printf("coda : %s%n", q);
        s1 = q.poll();
        System.out.printf("scodo: %s%n", s1);
        System.out.printf("coda : %s%n", q);

        q.offer(100);
        q.offer(200);
        q.offer(300);
        q.offerFirst(400); // come push?
        q.offerLast(500);

        System.out.printf("%ncoda : %s%n", q);

        // 7
        // int[] array = new int[] { 6, 5, 8, 4, 7, 10, 9 };
        int[] array = new int[] { 4, 3, 7, 5, 6, 4, 2 };
        System.out.println(days(array));

    }
}