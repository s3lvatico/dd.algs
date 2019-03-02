package org.gmnz.ddi.ch15.philosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Questo va in deadlock
 *
 * @author gemini
 *
 */
public class DiningPhilosophers {

	public static void main(String[] args) {
		Chopstick c0 = new Chopstick();
		Chopstick c1 = new Chopstick();
		Chopstick c2 = new Chopstick();

		Philosopher p1 = new Philosopher(c0, c1);
		Philosopher p2 = new Philosopher(c1, c2);
		Philosopher p3 = new Philosopher(c2, c0);

		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(p1);
		pool.execute(p2);
		pool.execute(p3);
		pool.shutdown();
	}
}
