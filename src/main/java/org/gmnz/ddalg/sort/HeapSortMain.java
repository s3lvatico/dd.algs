package org.gmnz.ddalg.sort;


public class HeapSortMain {

	private static final int HEAP_SIZE = 14;
	
	public static void main(String[] args) {
		int[] arr = new IntArrayUtils().generateRandomArray(HEAP_SIZE);
		IntArrayUtils.printCBT(arr);
		
		Heap h = new Heap();
		int[] arrSorted = h.heapSort(arr);
		IntArrayUtils.printCBT(arrSorted);
	}
}
