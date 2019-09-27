package org.gmnz.ddi.algs.uf;


public class QuickFindUF extends UnionFind {

	public QuickFindUF(int n) {
		super(n);
	}



	@Override
	public void union(int p, int q) {
		if (connected(p, q)) {
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i] == p) {
				id[i] = q;
			}
		}
		--nComponents;
	}



	@Override
	public int find(int p) {
		return id[p];
	}



	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

}
