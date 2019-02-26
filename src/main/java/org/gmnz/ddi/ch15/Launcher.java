package org.gmnz.ddi.ch15;


import java.util.concurrent.TimeUnit;


class Launcher implements Runnable {

	private static int id;

	private int timeout;



	public Launcher(int timeout) {
		++id;
		this.timeout = timeout;
	}



	@Override
	public void run() {
		while (timeout > 0) {
			System.out.format("<%d>%d.. ", id, timeout--);
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			}
			catch (InterruptedException e) {
				System.err.println("interrupted");
			}
		}
		System.out.format("<%d>ding!%n", id);
	}

}
