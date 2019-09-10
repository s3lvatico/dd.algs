package org.gmnz.ddi.ctci.ch4.graph_old;


public class IntegerKeyedGraph {

	static class Node {
		Integer key;
		String value;




		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}




		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Node other = (Node) obj;
			if (key == null) {
				if (other.key != null) {
					return false;
				}
			}
			else
				if (!key.equals(other.key)) {
					return false;
				}
			return true;
		}


	}

	// private Map<Node, List<Node>> adj;
}
