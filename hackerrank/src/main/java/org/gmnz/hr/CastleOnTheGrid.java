package org.gmnz.hr;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/*

   IL SUNTO : i nodi del grafo già esplorati non vengono immessi nella coda (come
   ovviamente previsto dal BFS), ma teoricamente non si deve interrompere l'esplorazione
   in una specifica direzione se si trova una cella già esplorata, BENSI' solo quando
   si incontra effettivamente un ostacolo (o la fine della griglia).
*/


public class CastleOnTheGrid {

   // questi due array sono usati per valutare le celle adiacenti.
   // nota che in realtà X e Y dovrebbero essere interpretati meglio come
   // ROW (X) e COLUMN (Y)
   static final int[] X_OFFSETS = { -1, 0, 1, 0 };
   static final int[] Y_OFFSETS = { 0, 1, 0, -1 };

   static int minimumMoves(String[] strings, int startX, int startY, int goalX, int goalY) {

      int size = strings.length;
      /*
       * trasforma l'array di stringhe in una griglia di char
       */
      char[][] grid = new char[size][size];
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            grid[i][j] = strings[i].charAt(j);
         }
      }

      // crea una griglia analoga in cui riporta il numero di mosse
      // necessarie per raggiungere una determinata cella a partire dalla
      // cella iniziale

      int[][] moves = new int[size][size];
      // IntStream.range(0, size).forEach(x -> Arrays.fill(moves[x], -1));

      // inizializza tutta la griglia delle mosse a -1, include così anche il
      // caso della cella non ancora visitata
      for (int[] row : moves) {
         Arrays.fill(row, -1);
      }

      // cella iniziale
      moves[startX][startY] = 0;

      // inizializza la coda con la cella iniziale
      Queue<Point> queue = new LinkedList<>();
      queue.offer(new Point(startX, startY));

      // loop infinito, credo si basi sul fatto che per ipotesi è sempre possibile
      // raggiungere la cella finale dalla cella iniziale, quindi sicuramente si
      // raggiunge l'enunciato return dentro questo while.
      // (non proprio generale, ma ci sta)
      while (true) {
         // prossima cella da valutare
         Point head = queue.poll();

         // controllo sulle quattro celle adiacenti
         for (int i = 0; i < X_OFFSETS.length; i++) {
            // prende la posizione corrente, che ora è pari
            // al punto di partenza
            int nextX = head.x;
            int nextY = head.y;

            // se la posizione adiacente, in una certa direzione, è libera
            while (isOpen(grid, nextX + X_OFFSETS[i], nextY + Y_OFFSETS[i])) {
               // esplora quella posizione aggiornando la posizione corrente
               nextX += X_OFFSETS[i];
               nextY += Y_OFFSETS[i];

               // se ha raggiunto la cella finale
               if (nextX == goalX && nextY == goalY) {
                  // riporta il numero di mosse
                  // impiegato per arrivarci
                  return moves[head.x][head.y] + 1;
               }

               // se la cella NON è stata ancora visitata
               if (moves[nextX][nextY] < 0) {
                  // nella griglia del numero di mosse, stabilisce che la cella
                  // che sto esplorando si raggiunge in una mossa (in più) rispetto
                  // alla cella da cui sono partito
                  moves[nextX][nextY] = moves[head.x][head.y] + 1;
                  queue.offer(new Point(nextX, nextY));
               }
               // QUESTO E' IL TRUCCO:
               // alla fine di questo ciclo while, la posizione corrente è già
               // stata aggiornata (si aggiorna a inizio ciclo, riguardalo);
               // adesso, poiché la posizione corrente è già aggiornata, mi sto
               // "muovendo" sempre in una direzione (cioè quella stabilita dall'
               // indice "i" del ciclo for), perciò continuo a esplorare la
               // griglia in questa direzione finché trovo celle esplorabili.
               // Tutte le celle esplorabili che trovo in questo modo sono sempre
               // raggiungibili con lo stesso numero di mosse, e sono anche sicuro
               // che questo numero di mosse sarà sempre minimo per le celle già
               // esplorate.

               // Ora la sfida è riportare questo risultato nella versione del
               // BFS che ho imparato da Sedgewick.
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
