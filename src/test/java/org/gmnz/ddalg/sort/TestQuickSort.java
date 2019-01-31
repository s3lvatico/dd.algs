package org.gmnz.ddalg.sort;


import org.junit.Assert;
import org.junit.Test;

import edu.princeton.cs.algs4.In;


public class TestQuickSort {

	@Test
	public void testWithNullArray() {
		AbstractSortEngine<String> sort = new QuickSort(null);
		Assert.assertTrue(sort.isSorted());
	}



	@Test
	public void testWithTinyFile() {
		String[] a = new In("qsortexample.txt").readAllStrings();
		AbstractSortEngine<String> sort = new QuickSort<>(a);
		sort.show();
		sort.sort();
		sort.show();
		Assert.assertTrue(sort.isSorted());
	}

}
