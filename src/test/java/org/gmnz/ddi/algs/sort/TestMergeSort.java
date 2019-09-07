package org.gmnz.ddi.algs.sort;

import org.junit.Assert;
import org.junit.Test;

import edu.princeton.cs.algs4.In;

public class TestMergeSort {

	@Test
	public void testWithNullArray() {
		AbstractSortEngine<String> sort = new MergeSortTopDown<>(null);
		Assert.assertTrue(sort.isSorted());
	}

	@Test
	public void testWithTinyFile() {
		String[] a = new In("mergesort-example.txt").readAllStrings();
		AbstractSortEngine<String> sort = new MergeSortTopDown<>(a);
		sort.show();
		sort.sort();
		sort.show();
		Assert.assertTrue(sort.isSorted());
	}

}
