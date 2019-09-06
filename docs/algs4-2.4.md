# Priority Qs

Nascono per soddisfare esigenze del tipo: ho un insieme di elementi, comparabili, magari dotati di chiave. Ho bisogno di eseguire certe operazioni su un sottoinsieme proprio di questi elementi, sottoinsieme che dovrebbe essere ordinato.

Le operazioni tipiche di una PQ sono

-   inserisci
-   estrai l'elemento massimo [minimo]

## soluzioni

### Rappresentazione con array non ordinato

L'inserimento è fatto sempre in coda all'array, l'estrazione del massimo presuppone l'individuazione dell'indice dell'elemento massimo, scorrendo l'array dall'inizio. Una volta determinato l'indice del massimo, lo si scambia con l'ultimo elemento dell'array. Viene quindi restituito l'ultimo elemento dell'array e poi si decrementa la dimensione logica dell'array (lazy, quella fisica rimane tale, e non viene nemmeno deallocato lo spazio occupato dal precedente ultimo elemento).

### Rappresentazione con array ordinato

L'array viene ordinato ad ogni inserimento di un nuovo elemento nella pq, facendo scorrere di un posto in avanti ogni elemento non minore di quello che si sta inserendo.

