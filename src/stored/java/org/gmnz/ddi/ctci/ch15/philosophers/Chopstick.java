package org.gmnz.ddi.ctci.ch15.philosophers;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Chopstick {

	private static int progId = 0;

	private int id;
	protected Lock lock;




	Chopstick() {
		id = ++progId;
		lock = new ReentrantLock();
	}




	void take() {
		lock.lock();
	}




	boolean tryTake() {
		return lock.tryLock();
	}




	void drop() {
		lock.unlock();
	}




	@Override
	public String toString() {
		return Integer.toString(id);
	}

}
