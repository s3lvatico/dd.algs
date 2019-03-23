package org.gmnz.ddi.ch15.critical_sections;


class PairOperator implements Runnable {
	private PairManager pm;




	public PairOperator(PairManager pm) {
		this.pm = pm;
	}




	@Override
	public void run() {
		while (true) {
			pm.increment();
		}
	}




	@Override
	public String toString() {
		return "Pair " + pm.getPair() + " | checkCounter " + pm.getCheckCounter();
	}
}
