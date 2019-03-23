package org.gmnz.ddi.ch15.threadlocal;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class TallyManOrchestrator {

	private static final int N_TASKS = 5;




	private static void sleep(long ms) {
		try {
			TimeUnit.MILLISECONDS.sleep(ms);
		}
		catch (InterruptedException e) {
		}
	}




	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		Shareable sharedObject = new ShareableImpl();
		for (int i = 0; i < N_TASKS; i++) {
			pool.execute(new TallyMan(i + 1, sharedObject));
		}
		sleep(1000);
		pool.shutdownNow();
		System.exit(0);
	}
}
