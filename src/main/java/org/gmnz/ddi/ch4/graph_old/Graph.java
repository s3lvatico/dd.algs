package org.gmnz.ddi.ch4.graph_old;


public interface Graph<KEY extends Comparable<KEY>, VALUE> {

	void add(KEY key, VALUE value);




	void connect(KEY k1, KEY k2);




	boolean contains(KEY k);

	// TODO getValue(KEY k); // ma sostanzialmente discende da contains(KEY)

}
