package org.gmnz.ddalg.pq;


abstract class AbstractHeap<KEY extends Comparable<KEY>> {

	protected KEY[] pq;
	protected int n = 0;



	AbstractHeap(int maxN) {
		pq = (KEY[]) new Comparable[maxN + 1];
	}


	protected boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	protected void swap(int i, int j) {
		KEY temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}



	protected void swim(int i, int n) {
		while(2*i <= n) {
			int j = 2*i;
			if (j < n && less(j, j+1)) {
				j++; 
			}
		}

	}
}
