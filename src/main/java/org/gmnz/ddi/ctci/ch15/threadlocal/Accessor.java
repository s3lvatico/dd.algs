package org.gmnz.ddi.ctci.ch15.threadlocal;


/**
 * @author gemini
 *
 */
class Accessor implements Runnable {

	/**
	 * identificativo di questo task
	 */
	private final int id;




	Accessor(int id) {
		this.id = id;
	}




	@Override
	public void run() {
		/*
		 * finché non viene interrotto, questo thread accede al campo di tipo
		 * ThreadLocal dell'oggetto condiviso
		 */
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}




	@Override
	public String toString() {
		return "#" + id + ": " + ThreadLocalVariableHolder.get();
	}

}
