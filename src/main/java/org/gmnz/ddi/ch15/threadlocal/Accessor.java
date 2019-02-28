package org.gmnz.ddi.ch15.threadlocal;

class Accessor implements Runnable {

	private final int id;



	Accessor(int id) {
		this.id = id;
	}



	@Override
	public void run() {
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
