package org.gmnz.ddalg.sort;


import java.util.Random;


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
		}
		return result;
	}



	public static void print(int[] arr) {
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

}
