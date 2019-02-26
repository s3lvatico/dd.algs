package org.gmnz.ddi.ch15.critical_sections;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class CriticalSections {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();

		PairManager pm1 = new PairManagerSynchronized();
		PairManager pm2 = new PairManagerLocked();

		PairOperator operator1 = new PairOperator(pm1);
		PairOperator operator2 = new PairOperator(pm2);

		PairChecker checker1 = new PairChecker(pm1);
		PairChecker checker2 = new PairChecker(pm2);

		pool.execute(operator1);
		pool.execute(operator2);
		pool.execute(checker1);
		pool.execute(checker2);

		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("operator1: " + operator1);
		System.out.println("operator2: " + operator2);
		System.exit(0);
	}
}
