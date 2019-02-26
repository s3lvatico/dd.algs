package org.gmnz.ddi.ch15.critical_sections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


abstract class PairManager {

	private AtomicInteger checkCounter;
	protected Pair p;

	private List<Pair> storage;



	PairManager() {
		checkCounter = new AtomicInteger(0);
		p = new Pair();
		storage = Collections.synchronizedList(new ArrayList<Pair>());
	}



	synchronized Pair getPair() {
		return new Pair(p.getX(), p.getY());
	}



	protected void store(Pair p) {
		storage.add(p);
		// facciamo finta che questa operazione richieda "parecchio" tempo

		try {
			TimeUnit.MILLISECONDS.sleep(50);
		}
		catch (InterruptedException e) {
		/* eccezione ignorata */ }
	}

	protected abstract void increment();

}
