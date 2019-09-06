# Priority Qs

Nascono per soddisfare esigenze del tipo: ho un insieme di elementi, comparabili, magari dotati di chiave. Ho bisogno di eseguire certe operazioni su un sottoinsieme proprio di questi elementi, sottoinsieme che dovrebbe essere ordinato.

Le operazioni tipiche di una PQ sono

-   inserisci
-   estrai l'elemento massimo [minimo]

## soluzioni

### Rappresentazione con array non ordinato

L'inserimento è fatto sempre in coda all'array, l'estrazione del massimo presuppone lo scorrimento del massimo finora individuato in coda all'array, e la sua successiva rimozione.

