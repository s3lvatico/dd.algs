package org.gmnz.ddi.ch15;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class LauncherRunner {

	private final int N_TASKS = 5;



	void run() {
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < N_TASKS; i++) {
			pool.execute(new Launcher(10));
		}
		pool.shutdown();
	}



	public static void main(String[] args) {
		LauncherRunner runner = new LauncherRunner();
		runner.run();
	}
}
