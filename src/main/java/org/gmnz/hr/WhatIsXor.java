package org.gmnz.hr;


public class WhatIsXor {

	public static void main(
			String[] args) {
		int x = 3;
		int y = 2;

		int z = x ^ y; //
		System.out.println(z);
		int t = 5;
		int k = t ^ x; // 101 ^ 011 = 110
		System.out.println(k);

		x = 2848;
		y = 3574;
		z = x ^ y;
		System.out.format("%d ^ %d = %d%n", x, y, z);
	}
}
