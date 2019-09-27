package org.gmnz.ddi.algs.uf;


public class WeightedUF extends QuickUnionUF {

	private int[] weight;


	public WeightedUF(int n) {
		super(n);
		weight = new int[n];
		for (int i = 0; i < n; i++) {
			weight[i] = 1;
		}
	}



	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		if (weight[pRoot] <= weight[qRoot]) {
			id[pRoot] = qRoot;
			weight[pRoot] += weight[qRoot];
		}
		else {
			id[qRoot] = pRoot;
			weight[qRoot] += weight[pRoot];
		}
		nComponents--;
	}


}
