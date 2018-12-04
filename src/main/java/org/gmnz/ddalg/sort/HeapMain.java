package org.gmnz.ddalg.sort;


public class HeapMain {

	public static void main(String[] args) {
		IntArrayUtils utils = new IntArrayUtils();
		int[] v = utils.generateRandomArray(15);
		IntArrayUtils.print(v);
		
		Heap h = new Heap();
		int[] w = h.maxHeapify(v);
		IntArrayUtils.print(w);
		
		int[] u = h.heapSort(w);
		IntArrayUtils.print(u);
		
		int[] q = h.heapSort(v);
		IntArrayUtils.print(q);
		
	}

}
