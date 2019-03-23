package org.gmnz.ddalg.graph3;


import java.util.Collection;


interface GraphAnalysis {

	boolean hasPathTo(int v);




	Collection<Integer> pathTo(int v);


}
