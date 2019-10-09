package org.gmnz.hr;


import java.io.IOException;
import java.net.URL;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


public class FraudulentActivityNotification {

    private int result;
    private int[] expenditure;
    private int d;

    public FraudulentActivityNotification(String inputFileName) throws IOException {
        URL inputFileUrl = FraudulentActivityNotification.class.getResource("/" + inputFileName);

        try (Scanner scanner = new Scanner(inputFileUrl.openStream())) {
            String[] nd = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nd[0]);

            d = Integer.parseInt(nd[1]);

            expenditure = new int[n];

            String[] expenditureItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int expenditureItem = Integer.parseInt(expenditureItems[i]);
                expenditure[i] = expenditureItem;
            }
        }
        result = activityNotifications(expenditure, d);
    }



    private int activityNotifications(int[] expenditure, int d) {

        int notifications = 0;

        Queue<Integer> q = new ArrayBlockingQueue<>(d);

        int maxExpense = -1;
        for (int x : expenditure) {
            if (x > maxExpense)
                maxExpense = x;
        }

        for (int i = 0; i < d; i++) {
            q.add(expenditure[i]);
        }

        int[] counts = new int[maxExpense + 1];

        for (int x : q) {
            counts[x]++;
        }

        int k = d;

        boolean notificationIssued = checkForFraud(counts, d, maxExpense, expenditure[k]);
        notifications += notificationIssued ? 1 : 0;

        while (k < expenditure.length - 1) {

            int expRemoved = q.remove();
            int expInserted = expenditure[k];
            q.add(expInserted);

            counts[expRemoved]--;
            counts[expInserted]++;

            k++;

            notificationIssued = checkForFraud(counts, d, maxExpense, expenditure[k]);
            notifications += notificationIssued ? 1 : 0;

        }

        return notifications;
    }



    private boolean checkForFraud(int[] count, int windowSize, int maxValue, int expense) {
        int[] sums = new int[maxValue + 1];
        sums[0] = count[0];
        if (windowSize % 2 == 1) {
            int p = windowSize / 2;
            for (int i = 1; i < count.length; i++) {
                int x = sums[i - 1] + count[i];
                if (x - 1 >= p) {
                    return expense >= 2 * i;
                } else {
                    sums[i] = x;
                }
            }
        } else {
            int p1 = windowSize / 2 - 1;
            int p2 = 1 + p1;
            boolean b1 = false;
            boolean b2 = false;
            int x1 = 0;
            int x2 = 0;
            for (int i = 1; i < count.length; i++) {
                int x = sums[i - 1] + count[i];
                if (x - 1 >= p1 && !b1) {
                    if (x - 1 >= p2) {
                        // se sono qui è perché il valore "i" è presente in un intervallo di indici del
                        // (futuro) array ordinato che include o travalica gli indici che servono a
                        // calcolare la mediana
                        return expense >= 2 * i;
                    } else {
                        x1 = i;
                        b1 = true;
                        sums[i] = x;
                        continue;
                    }
                }
                if (x - 1 >= p2) {
                    x2 = i;
                    b2 = true;
                }
                sums[i] = x;
                if (b1 && b2) {
                    break;
                }
            }
            return expense >= (x1 + x2);
        }
        throw new RuntimeException("non è stato trovato l'indice della mediana");
    }



    // getter
    public int getResult() {
        return result;
    }
}