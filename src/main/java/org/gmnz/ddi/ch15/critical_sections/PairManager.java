package org.gmnz.ddi.ch15.critical_sections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Decoratore per un {@link Pair}, per renderlo thread safe
 * 
 * @author gemini
 *
 */
abstract class PairManager {

	/**
	 * 
	 */
	protected Pair p;

	private AtomicInteger checkCounter;

	private List<Pair> storage;



	PairManager() {
		checkCounter = new AtomicInteger(0);
		p = new Pair();
		storage = Collections.synchronizedList(new ArrayList<Pair>());
	}



	/**
	 * Fornisce lo stato corrente del {@link Pair} gestito espresso come copia
	 * (clone) della classe decorata
	 * 
	 * @return
	 */
	synchronized Pair getPair() {
		return new Pair(p.getX(), p.getY());
	}



	/**
	 * Memorizza lo stato corrente di un {@link Pair} .
	 * <p>
	 * L'oggetto {@link Pair} da memorizzare viene fornito come parametro perché si
	 * vuole evitare di usare l'istanza della classe decorata.
	 * 
	 * @param p
	 */
	protected void store(Pair p) {
		storage.add(p);
		// facciamo finta che questa operazione richieda "parecchio" tempo
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		}
		catch (InterruptedException e) {
			/* eccezione ignorata */ }
	}



	int getCheckCounter() {
		return checkCounter.get();
	}



	int incrementAndGetCheckCounter() {
		return checkCounter.incrementAndGet();
	}



	void checkPairState() {
		p.checkState();
	}



	/**
	 * Modifica lo stato del {@link Pair} gestito.
	 * <p>
	 * Nell'esempio che si vuole dimostrare, la classe {@link Pair} è non-threadsafe
	 * in modo evidente. L'operazione di esempio che si esegue sulle sue istanze è
	 * una sequenza di chiamate ai metodi di incremento dei campi. Questo può creare
	 * inconsistenze di stato rispetto all'invariante definito nella classe Pair
	 * stessa (cioè il metodo {@link Pair#checkState()}, che controlla che i campi
	 * siano uguali).
	 * <p>
	 * Una medesima istanza di {@link PairManager} viene condivisa da almeno una
	 * coppia di thread. Uno di essi può occuparsi dell'incremento dello stato del
	 * Pair gestito, mentre un altro thread può chiamare periodicamente
	 * l'invariante. E' quindi necessario che le implementazioni di
	 * {@link #increment()} rendano threadsafe la modifica dello stato del Pair
	 * gestito.
	 */
	protected abstract void increment();

}
