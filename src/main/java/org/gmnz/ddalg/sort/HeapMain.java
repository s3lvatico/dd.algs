package org.gmnz.ddalg.sort;


public class HeapMain {

	public static void main(String[] args) {
		IntArrayUtils utils = new IntArrayUtils();
		int[] v = utils.generateRandomArray(15);
		IntArrayUtils.printCBT(v);
		
		Heap h = new Heap();
		int[] w = h.maxHeapify(v);
		IntArrayUtils.printCBT(w);
		
		int[] u = h.heapSort(w);
		IntArrayUtils.printCBT(u);
		
		int[] q = h.heapSort(v);
		IntArrayUtils.printCBT(q);
		
	}

}
