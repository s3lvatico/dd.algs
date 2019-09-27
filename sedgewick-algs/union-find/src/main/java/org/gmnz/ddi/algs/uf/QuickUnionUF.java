package org.gmnz.ddi.algs.uf;


public class QuickUnionUF extends UnionFind {


	public QuickUnionUF(int n) {
		super(n);
	}



	@Override
	public void union(int p, int q) {
		id[p] = q;
		nComponents--;
	}



	@Override
	public int find(int p) {
		int x = p;
		while (x != id[x]) {
			x = id[x];
		}
		return x;
	}



	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}


}
