package org.gmnz.ddi.ch15.critical_sections;


import java.util.concurrent.atomic.AtomicInteger;


/**
 * Task client per {@link PairManager} che controlla la consistenza dello stato
 * del {@link Pair} decorato.
 * <p>
 * Durante l'esecuzione sono esercitati i metodi
 * {@link AtomicInteger#incrementAndGet()} e {@link Pair#checkState()}.
 *
 */
class PairChecker implements Runnable {

	private PairManager pm;



	public PairChecker(PairManager pm) {
		this.pm = pm;
	}



	@Override
	public void run() {
		while (true) {
			pm.checkCounter.incrementAndGet();
//			try {
			pm.pair.checkState();
//			} catch (PairValuesNotEqualException e) {
//				System.err.println("ops!");
//			}
		}
	}



	@Override
	public String toString() {
		return "Pair " + pm.getPair() + " | checkCounter " + pm.checkCounter;
	}
}
