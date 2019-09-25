package org.gmnz.ddi.algs.sort;


import org.gmnz.ddi.algs.sort.AbstractSortEngine;
import org.gmnz.ddi.algs.sort.InsertionSort;
import org.gmnz.ddi.algs.sort.SelectionSort;
import org.junit.Assert;
import org.junit.Test;

import edu.princeton.cs.algs4.In;


public class TestInsertionSort {

	@Test
	public void testWithNullArray() {
		AbstractSortEngine<String> sort = new SelectionSort<String>(null);
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
