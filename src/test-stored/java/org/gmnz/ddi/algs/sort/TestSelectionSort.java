package org.gmnz.ddi.algs.sort;


import org.junit.Assert;
import org.junit.Test;

import edu.princeton.cs.algs4.In;


public class TestSelectionSort {

	@Test
	public void testWithNullArray() {
		AbstractSortEngine<String> sort = new SelectionSort<>(null);
		Assert.assertTrue(sort.isSorted());
	}



	@Test
	public void testWithTinyFile() {
		String[] a = new In("tiny.txt").readAllStrings();
		AbstractSortEngine<String> sort = new SelectionSort<>(a);
		sort.show();
		sort.sort();
		sort.show();
		Assert.assertTrue(sort.isSorted());
	}

}
