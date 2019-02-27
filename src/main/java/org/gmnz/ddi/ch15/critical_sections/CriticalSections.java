package org.gmnz.ddi.ch15.critical_sections;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class CriticalSections {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();

		PairManager pmSynchronized = new PairManagerSynchronized();
		PairManager pmWithLock = new PairManagerLocked();
		PairManager pmWithInternalLock = new PairManagerWithLock();

		PairOperator operatorSynchronized = new PairOperator(pmSynchronized);
		PairOperator operatorWithLock = new PairOperator(pmWithLock);
		PairOperator operatorWithInternalLock = new PairOperator(pmWithInternalLock);

		PairChecker checkerForSynchronized = new PairChecker(pmSynchronized);
		PairChecker checkerForLock = new PairChecker(pmWithLock);
		PairChecker checkerForInternalLock = new PairChecker(pmWithInternalLock);

		pool.execute(checkerForSynchronized);
		pool.execute(checkerForLock);
		pool.execute(checkerForInternalLock);

		pool.execute(operatorSynchronized);
		pool.execute(operatorWithLock);
		pool.execute(operatorWithInternalLock);

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("operatorSynchronized     : " + operatorSynchronized);
		System.out.println("operatorWithLock         : " + operatorWithLock);
		System.out.println("operatorWithInternalLock : " + operatorWithInternalLock);
		System.exit(0);
	}
}
