package org.gmnz.ddi.ch15.threadlocal;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ThreadLocalVariableHolder {

//@formatter:off
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {

		private Random rnd = new Random(47);

		@Override
		protected synchronized Integer initialValue() {
			return rnd.nextInt(10000);
		}
	};

	public static Integer get() { return value.get(); }
	public static void increment() { value.set(value.get() + 1); }
//@formatter:on



	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			pool.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(1);
		pool.shutdownNow();
	}

}
