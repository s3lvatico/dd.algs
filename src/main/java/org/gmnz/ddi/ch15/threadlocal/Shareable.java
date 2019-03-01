package org.gmnz.ddi.ch15.threadlocal;


/**
 * Ha un contatore interno che si inizializza ad un valore casuale al primo
 * accesso. Fornisce metodi per incrementare il contatore e conoscerne il valore
 * corrente.
 *
 * @author gemini
 *
 */
public interface Shareable {

	/**
	 * incrementa un contatore interno
	 */
	void increment();



	/**
	 * fornisce il valore corrente del contatore interno
	 *
	 * @return
	 */
	int getValue();
}
