package org.gmnz.ddi.ch15.threadlocal;


import java.util.concurrent.TimeUnit;


class TallyMan implements Runnable {

	private final int id;
	private final Shareable shareable;



	TallyMan(int id, Shareable s) {
		this.id = id;
		this.shareable = s;
	}



	@Override
	public String toString() {
		return String.format("#%d-%d", id, shareable.getValue());
	}



	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			shareable.increment();
			System.out.println(this);
			Thread.yield();
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			}
			catch (InterruptedException e) {
			}
		}
	}
}
