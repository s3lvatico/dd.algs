package org.gmnz.ddi.ch15.critical_sections;


class PairChecker implements Runnable {
	private PairManager pm;



	public PairChecker(PairManager pm) {
		this.pm = pm;
	}



	@Override
	public void run() {
		while (true) {
			pm.incrementAndGetCheckCounter();
			pm.checkPairState();
		}
	}



	@Override
	public String toString() {
		return "Pair " + pm.getPair() + " | checkCounter " + pm.getCheckCounter();
	}
}
