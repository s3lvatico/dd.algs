# tabelle hash

## appunti

Generalmente se le chiavi di ricerca sono riconducibili a interi piccoli, si può usare un array indicizzato usando le chiavi come indici dell'array.

L'*hashing* è una tecnica che estende questo metodo, che consiste in due operazioni. La prima operazione è il calcolo di una funzione di *hash* che trasforma la chiave di ricerca in un indice (volendo, un indice di un array). La seconda operazione è la soluzione del problema delle collisioni.

## Hashing per interi positivi

Il metodo di hashing più usato per gli interi positivi si chiama "hashing modulare" (*modular hashing*). Detto M un numero primo usato come dimensione dell'array (i.e. il numero di codici distinti idealmente), si definisce la funzione di hashing per ogni chiave intera positiva quella che associa ad ogni chiave la chiave modulo M.

## Per i numeri in virgola mobile

Fossero numeri tra 0 e 1 basta moltiplicarli per M (vedi paragrafo precedente) e poi arrotondare all'intero più vicino.

## Hashing per le stringhe

Considerando la stringa come una sequenza di caratteri, e considerando che ogni carattere si può mappare su un numero intero, l'hash viene calcolato così:

    int hash = 0;
    for (int i = 0; i< s.length(); i++) {
        hash = ( R*hash + s.charAt(i)) % M;
    }

Nell'esempio, `s ` è la stringa, `R` è come una base numerica, e `M` è il numero solito di hash che si vogliono rendere disponibili.


        
