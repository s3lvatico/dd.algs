package org.gmnz.ddalg.sort;


import java.util.Random;
import java.util.concurrent.TimeUnit;


public class IntArrayUtils {

	private final Random random;

	private static final int RANGE = 100;



	public IntArrayUtils() {
		random = new Random();
	}



	public int[] generateRandomArray(int size) {
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = random.nextInt(RANGE);
			Thread.yield();
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) { /* ignorata */ }
		}
		return result;
	}



	public static void print(int[] arr) {
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}



	public static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}



	public static void printCBT(int[] arr) {
		int exp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i > 0 && (i + 1) % Math.pow(2, exp) == 0) {
				System.out.print("   ");
				++exp;
			}
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}
}
