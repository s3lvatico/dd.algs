package org.gmnz.hr;


import java.util.Arrays;
import java.util.Random;


public class FraudulentActivityNotification {

    static int activityNotifications(int[] expenditure, int d) {

        /*
         * l'array expenditure è ENORME
         * 
         * l'intero d è un sottoinsieme dell'array
         * 
         * l'idea iniziale è:
         * 
         * prendi i primi d elementi di expenditure copiali in un array lungo d ordinare
         * questo secondo array trova la mediana valuta la mediana
         * 
         * dalla posizione d+1 devi fare altro togliere l'elemento che in expenditure è
         * più vecchio >> ogni elemento del mio array da ordinare porta con sé
         * l'informazione sulla posizione che ha nell'array originale inserire
         * l'elemento nuovo (magari già in ordine) trovare mediana valutare mediana
         */

        /*
         * soluzione che spreca spazio [ q y x t l j k m ] v [ 0 1 2 3 4 5 6 7 ]
         * 
         * supponi d=3
         * 
         * scansione con "r". r comincia da d in 0..d-1 carico in un altro array, un
         * array "di lavoro", diciamo w [ q y x ] w ... length(w) = 3 = d [ 0 1 2 ] la
         * prima volta è sort dell'array [ q x y ] w [ 0 2 1 ] ==> trova mediana (che
         * vale x) + verifica se "t" >= 2*x poi il nuovo elemento andrebbe inserito in
         * w. qual è il nuovo elemento? è t, è quello in posizione r, lo so perché lo
         * sto analizzando ora. quale elemento devo togliere da w? quello che nell'array
         * originale è in posizione r-d PROBLEMA: come metto in relazione le posizioni
         * dell'array originale e le posizioni dell'array ordinato? Trovare una
         * struttura dati che mi dice
         * "l'elemento in posizione j in v, sta in posizione k in w"
         * 
         * Basterebbe un array lungo quanto v? forse sì perché è biunivoco con v, e
         * poiché length(w) <= length(v)
         */

        /*
         * 
         * altra via
         * 
         * supponiamo d = 5, length(v) >> 5
         * 
         * 
         * 
         */
        final int L = expenditure.length;

        // array per il calcolo della mediana
        int[] window = new int[d];

        // mappa
        int[] windowMap = new int[d];

        // inizializzato a -1
        Arrays.fill(window, -1);
        print(window);

        // indice di scansione dell'array principale
        int k = 0;

        // scansione array principale
        while (k < L) {

            // ciclo transitorio per l'array secondario
            if (k < d) {
                insertAndSort(expenditure, k, window, windowMap);
            }
            else {
                // TODO ramo else da aggiungere

            }
            k++;
        }

        return -1;
    }

    /*
     * MOMENTO , altra idea
     * 
     * invece di usare un array parallelo lungo quanto quello iniziale, potrei
     * usarne uno parallelo lungo quanto la finestra di osservazione. In questo
     * array mantengo l'indice che l'elemento i-esimo della finestra ha sull'array
     * iniziale.
     * 
     * Qualcosa del tipo:
     * 
     * int[] windowMap, windowMap.length = window.length
     * 
     * se esistono x, i_1 tali che expenditures[i_1] = x allora esistendo i_2 tale
     * che window[i_2] = x, risulta windowMap[i_2] = i_1
     */



    private static void insertAndSort(int[] exp, int k, int[] w, int[] map) {
        // indice per la scansione
        int i = 0;

        int wlen = w.length;

        int x = exp[k];

        // ci si ferma quando questo è true
        boolean inserted = false;

        while (i < wlen && !inserted) {
            if (w[i] == -1) {
                w[i] = x;
                map[i] = k;
                inserted = true;
            }
            else {
                if (x < w[i]) {
                    // x deve stare in posizione i

                    // salva il vecchio contenuto di w in i
                    int y = w[i];
                    // aggiorna w[i]
                    w[i] = x;

                    // salva il vecchio valore della mappa
                    int mapIdx = map[i];
                    // aggiorna la mappa
                    map[i] = k;

                    int j = i + 1;
                    while (j < wlen && y != -1) {
                        // aggiorna i successivi valori nella finestra
                        int z = w[j];
                        w[j] = y;
                        y = z;

                        // aggiorna i successivi valori nella mappa
                        int a = map[j];
                        map[j] = mapIdx;
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



    private static void print(int[] v) {
        StringBuilder sb = new StringBuilder("[");
        for (int x : v) {
            sb.append(String.format("%4d", x));
        }
        sb.append("  ]");
        System.out.println(sb.toString());
    }



    public static void main(String[] args) {
        Random r = new Random();
        final int L = 15;
        int[] v = new int[L];
        for (int i = 0; i < L; i++) {
            v[i] = r.nextInt(50);
        }
        print(v);

        int d = 5;
        System.out.println(activityNotifications(v, d));
    }

}