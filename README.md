# M-Ary-Tree-JAVA
Questo progetto in Java implementa un albero m-ario, che è un tipo di struttura dati albero in cui ogni nodo ha un numero m di figli. Ecco una panoramica delle caratteristiche principali del progetto:

Classe AlberoMArio: Questa classe rappresenta l'albero m-ario e contiene metodi per gestire e manipolare l'albero. Alcuni dei metodi principali includono:

numFigli(): Restituisce il numero di figli massimo consentito per ciascun nodo.
radice(): Restituisce la radice dell'albero o null se l'albero è vuoto.
info(Nodo_m_ario<String> v): Restituisce il contenuto/informazione del nodo specificato.
numNodi(): Restituisce il numero totale di nodi nell'albero.
altezza(): Restituisce l'altezza dell'albero.
grado(Nodo_m_ario<String> v): Restituisce il grado (numero di figli) del nodo specificato.
sin(Nodo_m_ario<String> v): Restituisce il figlio sinistro del nodo specificato.
padre(Nodo_m_ario<String> v): Restituisce il padre del nodo specificato.
livello(Nodo_m_ario<String> v): Restituisce il livello del nodo specificato.
cambiaInfo(Nodo_m_ario<String> v, String info): Cambia il contenuto del nodo specificato.
aggiungiRadice(String info): Inserisce la radice in un albero vuoto e la restituisce.
aggiungiFiglioSin(Nodo_m_ario<String> u, String info): Inserisce un nodo come figlio sinistro del nodo specificato.
aggiungiFiglioDes(Nodo_m_ario<String> u, String info): Inserisce un nodo come figlio destro del nodo specificato.
visitaDFS(): Visita l'albero in profondità utilizzando un approccio iterativo.
visitaBFS(): Visita l'albero in ampiezza utilizzando un approccio iterativo.
innesco_visita(String t): Innesca una visita ricorsiva dell'albero, specificando il tipo di visita desiderata ("anticipata", "simmetrica" o "posticipata").
Classe Nodo_m_ario: Questa classe rappresenta un nodo nell'albero m-ario e contiene le informazioni e i riferimenti necessari per rappresentare il nodo. Alcuni dei metodi principali includono:

Costruttore per creare un nuovo nodo con un'informazione specificata.
getInfo(): Restituisce l'informazione contenuta nel nodo.
getPadre(): Restituisce il padre del nodo.
setInfo(String x): Imposta l'informazione contenuta nel nodo.
setPadre(Nodo_m_ario<String> v): Imposta il padre del nodo.
livello(): Calcola e restituisce il livello del nodo nell'albero.
getChildren(): Restituisce i figli del nodo.
setChildren(ArrayList<Nodo_m_ario<String>> children): Imposta i figli del nodo.
Inoltre, il progetto implementa metodi per la visita dell'albero sia in profondità che in ampiezza, sia in modo iterativo che ricorsivo. La classe Nodo_m_ario gestisce anche la struttura dei figli del nodo.
