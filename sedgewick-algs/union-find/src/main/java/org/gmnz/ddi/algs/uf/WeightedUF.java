package org.gmnz.ddi.algs.uf;

public class WeightedUF extends QuickUnionUF {

	/**
	 * array dei pesi
	 */
	private int[] weight;

	public WeightedUF(int n) {
		super(n);
		weight = new int[n];
		// all'inizio ogni nodo ha peso 1
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
		// si aggiunge sempre il più leggero al più pesante
		if (weight[pRoot] <= weight[qRoot]) {
			id[pRoot] = qRoot;
			weight[pRoot] += weight[qRoot];
		} else {
			id[qRoot] = pRoot;
			weight[qRoot] += weight[pRoot];
		}
		nComponents--;
	}

}
