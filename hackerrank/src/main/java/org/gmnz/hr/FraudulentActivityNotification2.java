package org.gmnz.hr;

import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class FraudulentActivityNotification2 {

    static int activityNotifications(int[] expenditure, int d) {

        int notifications = 0;

        final int L = expenditure.length;

        Queue<Integer> q = new ArrayBlockingQueue<>(d);

        int maxValue = -1;

        for (int i = 0; i < d; i++) {
            q.add(expenditure[i]);
            if (expenditure[i] > maxValue) {
                maxValue = expenditure[i];
            }
        }

        int[] counts = new int[maxValue + 1];
        int[] sums = new int[maxValue + 1];

        for (int x : q) {
            counts[x]++;
        }
        for (int i = 1; i < counts.length; i++)
            sums[i] = sums[i-1] + counts[i];
            

        int k = d;
        while (k < L) {

            // print(window);
            k++;
        }

        return notifications;
    }

    private static void insertAndSort(int[] exp, int k, int[] w, int[] windowMap) {
        // indice per la scansione
        int i = 0;

        int wlen = w.length;

        int x = exp[k];

        // ci si ferma quando questo è true
        boolean inserted = false;

        while (i < wlen && !inserted) {
            if (w[i] == -1) {
                w[i] = x;
                windowMap[i] = k;
                inserted = true;
            } else {
                if (x < w[i]) {
                    // x deve stare in posizione i

                    // salva il vecchio contenuto di w in i
                    int y = w[i];
                    // aggiorna w[i]
                    w[i] = x;

                    // salva il vecchio valore della mappa
                    int mapIdx = windowMap[i];
                    // aggiorna la mappa
                    windowMap[i] = k;

                    int j = i + 1;
                    while (j < wlen && y != -1) {
                        // aggiorna i successivi valori nella finestra
                        int z = w[j];
                        w[j] = y;
                        y = z;

                        // aggiorna i successivi valori nella mappa
                        int a = windowMap[j];
                        windowMap[j] = mapIdx;
                        mapIdx = a;

                        // avanza
                        j++;
                    }
                    inserted = true;
                }
            }
            i++;
        }
    }

    private static void reorder(int[] w, int[] map, int p) {
        final int l = w.length - 1;
        if (p == 0) {
            // estremo sx
            shiftToRight(p, w, map, l);
        } else if (p == l) {
            // estremo dx
            shiftToLeft(p, w, map);
        } else {
            // da qualche parte in mezzo
            if (w[p] > w[p + 1]) {
                shiftToRight(p, w, map, l);
            } else if (w[p] < w[p - 1]) {
                shiftToLeft(p, w, map);
            }
        }
    }

    private static void shiftToRight(int i, int[] w, int[] map, int l) {
        while (i < l && w[i] > w[i + 1]) {
            int x = w[i];
            w[i] = w[i + 1];
            w[i + 1] = x;

            x = map[i];
            map[i] = map[i + 1];
            map[i + 1] = x;

            i++;
        }
    }

    private static void shiftToLeft(int i, int[] w, int[] map) {
        while (i > 0 && w[i] < w[i - 1]) {
            int x = w[i];
            w[i] = w[i - 1];
            w[i - 1] = x;

            x = map[i];
            map[i] = map[i - 1];
            map[i - 1] = x;

            i--;
        }

    }

    private static boolean suspectFraud(int expense, int[] w) {
        return expense >= findMedian(w) * 2;
    }

    private static double findMedian(int[] v) {
        int l = v.length;
        if (l % 2 == 1) {
            // . . . . . . .
            return (double) v[l / 2];
        } else {
            // . . . . . . . .
            return ((double) v[l / 2] + v[l / 2 + 1]) / 2;
        }
    }

    private static void print(int[] v) {
        StringBuilder sb = new StringBuilder("[");
        for (int x : v) {
            sb.append(String.format("%4d", x));
        }
        sb.append("  ]");
        System.out.println(sb.toString());
    }

    // public static void main(String[] args) {
    // Random r = new Random();
    // final int L = 15;
    // int[] v = new int[L];
    // for (int i = 0; i < L; i++) {
    // v[i] = r.nextInt(50);
    // }
    // print(v);

    // int d = 5;
    // System.out.println(activityNotifications(v, d));

    // }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}