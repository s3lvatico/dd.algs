package org.gmnz.ddi.algs.sort;

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

	@Test
	public void testGeneric() {
		AbstractSortEngine<String> qSort = new QuickSort<String>(new String[] { "F", "A", "C", "D", "K", "R" });
		qSort.show();
		qSort.sort();
		Assert.assertTrue(qSort.isSorted());
	}

	@Test
	public void testOneElement() {
		AbstractSortEngine<String> qSort = new QuickSort<String>(new String[] { "QQ" });
		qSort.show();
		qSort.sort();
		Assert.assertTrue(qSort.isSorted());
	}
}
