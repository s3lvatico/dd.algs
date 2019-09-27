package org.gmnz.ddi.ctci.ch4.graph_old;


/**
 * @deprecated         è stato pensato troppo complicato per un ADT che dovrebbe
 *                     essere usato per studiare
 * @param      <KEY>
 * @param      <VALUE>
 */
public interface Graph<KEY extends Comparable<KEY>, VALUE> {

	void add(KEY key, VALUE value);


	void connect(KEY k1, KEY k2);


	boolean contains(KEY k);

	// getValue(KEY k); // ma sostanzialmente discende da contains(KEY)

}
