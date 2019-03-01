package org.gmnz.ddi.ch15.threadlocal;


class ShareableImpl implements Shareable {

	private ThreadLocalValue value;



	ShareableImpl() {
		value = new ThreadLocalValue();
	}



	@Override
	public void increment() {
		value.set(value.get() + 1);
	}



	@Override
	public int getValue() {
		return value.get();
	}

}
