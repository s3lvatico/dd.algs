package org.gmnz.ddi.ch15.critical_sections;


/**
 * Questa versione sincronizza l' intero metodo
 *
 * @author gemini
 *
 */
class PairManagerSynchronized extends PairManager {

	@Override
	protected synchronized void increment() {
		p.incrementX();
		p.incrementY();
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
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}

}
