package org.gmnz.ddi.ctci.ch15.threadlocal;


import java.util.Random;


/**
 * Specializzazione di ThreadLocal per un intero.
 * <p>
 * Il valore iniziale visto da ogni thread che chiamasse il metodo get() senza
 * prima aver invocato set() su questo oggetto è impostato casualmente
 *
 * @author gemini
 *
 */
class ThreadLocalValue extends ThreadLocal<Integer> {

	private Random rnd = new Random(53280);




	@Override
	protected Integer initialValue() {
		return rnd.nextInt(1000);
	}

}
