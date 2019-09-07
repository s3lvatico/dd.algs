package org.gmnz.ddi.ctci.ch15.threadlocal;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * L'obiettivo è dimostrare che thread distinti che accedono al medesimo
 * oggetto, dotato però di un campo ThreadLocal, vedono ciascuno una copia
 * specifica di quel campo. Ad un'istanza di questa classe verrà fatto accedere
 * un numero di thread distinti che opereranno direttamente su un campo statico.
 * <p>
 * Perché il campo è dichiarato static? Forse per rafforzare ancora di più il
 * fatto che usando un campo ThreadLocal anche nelle condizioni di "massimo
 * pericolo" si ottiene comunque la thread-safety? Un esempio simile l'ho
 * realizzato nella classe TallyManOrchestrator, che forse è un po' meno
 * contorta di questo esempio.
 *
 * @author gemini
 *
 */
public class ThreadLocalVariableHolder {

//@formatter:off
	private static ThreadLocalValue value = new ThreadLocalValue();
	public static Integer get() { return value.get(); }
	public static void increment() { value.set(value.get() + 1); }
//@formatter:on




	/**
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			pool.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(1);
		pool.shutdownNow();
	}

}
