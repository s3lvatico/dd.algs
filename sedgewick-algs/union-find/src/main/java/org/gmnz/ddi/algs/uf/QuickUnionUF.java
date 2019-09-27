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




	public static void main(String[] args) {
		UnionFind uf = new QuickUnionUF(5);
		System.out.println(uf.nComponents);
		System.out.println(uf.connected(0, 1));
		System.out.println(uf.connected(2, 3));
		System.out.println(uf.connected(4, 0));
		uf.union(3, 4);
		System.out.println(uf.nComponents);
		System.out.println(uf.connected(3, 4));
	}

}
