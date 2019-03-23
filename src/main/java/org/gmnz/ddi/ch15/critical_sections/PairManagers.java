package org.gmnz.ddi.ch15.critical_sections;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Questa versione sincronizza l' intero metodo
 *
 * @author gemini
 *
 */
class PairManagerSynchronized extends PairManager {

	@Override
	protected synchronized void increment() {
		pair.incrementX();
		pair.incrementY();
		store(getPair());
	}
} // ˜ PairManagerSynchronized






/**
 * Questa versione usa una sezione protetta
 *
 * @author gemini
 *
 */
class PairManagerLocked extends PairManager {

	@Override
	protected void increment() {
		Pair temp;
		synchronized (this) {
			pair.incrementX();
			pair.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}






/**
 * Versione che sincronizza usando un {@link Lock} interno alla classe.
 *
 * @author Simone Monotti
 *
 */
class PairManagerWithLock extends PairManager {

	private final Lock lock = new ReentrantLock();




	@Override
	protected void increment() {
		Pair temp;
		lock.lock();
		try {
			pair.incrementX();
			pair.incrementY();
			temp = getPair();
		}
		finally {
			lock.unlock();
		}
		store(temp);
	}

}
