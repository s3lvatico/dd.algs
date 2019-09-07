package org.gmnz.ddi.algs.uf;


abstract class UnionFind {

	protected int[] id;
	protected int nComponents;




	public abstract void union(int p, int q);




	public abstract int find(int p);




	/**
	 * @param p
	 * @param q
	 * @return <code>true</code> se gli elementi p e q appartengono allo stesso
	 *         componente
	 */
	public abstract boolean connected(int p, int q);




	public UnionFind(int n) {
		id = new int[n];
		nComponents = n;
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
}
