package org.gmnz.ddi.ch15.critical_sections;


class Pair {
	private int x;
	private int y;



	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}



	Pair() {
		x = 0;
		y = 0;
	}



	int getX() {
		return x;
	}



	void setX(int x) {
		this.x = x;
	}



	int getY() {
		return y;
	}



	void setY(int y) {
		this.y = y;
	}



	void incrementX() {
		x++;
	}



	void incrementY() {
		y++;
	}



	@Override
	public String toString() {
		return String.format("[x=%s, y=%s]", x, y);
	}



	void checkState() {
		if (x != y) {
			throw new PairValuesNotEqualException();
		}
	}

	public class PairValuesNotEqualException extends RuntimeException {

		private static final long serialVersionUID = -9050108865000593325L;



		public PairValuesNotEqualException() {
			super("Pair values not equal: " + Pair.this);
		}
	}

}
