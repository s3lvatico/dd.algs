package org.gmnz.ddalg.sort;


import org.junit.Assert;
import org.junit.Test;

import edu.princeton.cs.algs4.In;


public class TestInsertionSort {

	@Test
	public void testWithNullArray() {
		AbstractSortEngine<String> sort = new SelectionSort<>(null);
		Assert.assertTrue(sort.isSorted());
	}



	@Test
	public void testWithTinyFile() {
		String[] a = new In("tinyNumbers.txt").readAllStrings();
		AbstractSortEngine<String> sort = new InsertionSort<>(a);
		sort.show();
		sort.sort();
		sort.show();
		Assert.assertTrue(sort.isSorted());
	}

}
