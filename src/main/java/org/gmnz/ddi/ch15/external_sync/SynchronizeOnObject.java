package org.gmnz.ddi.ch15.external_sync;


import java.util.concurrent.TimeUnit;


/**
 * Un blocco <code>synchronized</code> deve necessariamente avere un oggetto
 * rispetto al quale sincronizzare; e tipicamente l'oggetto più "sensibile" che
 * si usa è proprio l'oggetto corrente il cui metodo contiene il blocco
 * sincronizzato. Per questo si usa il <code>synchronzied(this)</code>.
 * <p>
 * In questo modo, quando il lock è acquisito per il blocco dichiarato
 * <code>synchronized</code>, gli eventuali altri metodi o porzioni di codie
 * dichiarati sincronizzati <b>non</b> possono essere chiamati. Pertanto, quando
 * si sincronizza su <code>this</code> si ottiene un blocco "totale"
 * dell'oggetto.
 * <p>
 * Può esistere peraltro la necessità di sincronizzare usando un oggetto
 * esterno, ma in questo caso bisogna aver cura di fare in modo che tutti i task
 * siano sincronizzati sul medesimo oggetto.
 * <p>
 * Vogliamo dimostrare che due task possono chiamare metodi distinti di un
 * oggetto se quei metodi si sincronizzano su lock distinti.
 *
 *
 */
public class SynchronizeOnObject {

	public static void main(String[] args) {
		final DualSync ds = new DualSync();

		// usa un thread esterno per invocare uno dei metodi
		new Thread() {

			@Override
			public void run() {
				ds.f();
			}
		}.start();

		// invoca l'altro metodo dal thread corrente
		ds.g();
	}

}





class DualSync {

	private Object syncObject = new Object();



	/**
	 * come dire che sincronizza su "THIS"
	 */
	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			System.out.format("%30s f()%n", Thread.currentThread());
			Thread.yield();
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {}
		}
	}



	public void g() {
		synchronized (syncObject) {
			for (int i = 0; i < 5; i++) {
				System.out.format("%30s g()%n", Thread.currentThread());
				Thread.yield();
			}
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {}
		}
	}

}
