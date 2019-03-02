package org.gmnz.ddi.ch15.philosophers;


class Philosopher implements Runnable {

	private static int prog_id = 0;

	private final int id;
	private final Chopstick left, right;

	private static final int N_BITES = 5;



	Philosopher(Chopstick left, Chopstick right) {
		this.id = ++prog_id;
		this.left = left;
		this.right = right;
	}



	private void eat() {
		System.out.format("P%d-L%s.R%s nomnom%n", id, left, right);
	}



	boolean pickUp() {
		if (!left.tryTake()) {
			return false;
		}
		if (!right.tryTake()) {
			left.drop();
			return false;
		}
		return true;

	}



	void putDown() {
		right.drop();
		left.drop();
	}



	@Override
	public void run() {
		for (int i = 0; i < N_BITES; i++) {
//			System.out.format("P%d trying to take L%s%n", id, left);
//			left.take();
//			System.out.format("P%d picked L%s up, trying now to take R%s%n", id, left, right);
//			right.take();
//			System.out.format("P%d picked R%s up%n", id, right);
//			eat();
//			System.out.format("P%d now dropping both sticks%n", id);
//			right.drop();
//			left.drop();
//			System.out.format("P%d all sticks dropped%n", id);
			System.out.format("P%d [%d] trying to take sticks%n", id, i);
			if (pickUp()) {
				System.out.format("P%d ok%n", id);
				eat();
				putDown();
			}
			Thread.yield();
		}
	}


}
