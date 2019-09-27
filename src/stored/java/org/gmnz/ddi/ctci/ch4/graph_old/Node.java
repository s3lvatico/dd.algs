package org.gmnz.ddi.ctci.ch4.graph_old;


class Node<KEY extends Comparable<KEY>, VALUE> {

	protected KEY key;
	protected VALUE value;




	Node(KEY key, VALUE value) {
		this.key = key;
		this.value = value;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}




	@Override @SuppressWarnings("unchecked")
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
		Node<KEY, VALUE> other = (Node<KEY, VALUE>) obj;
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




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [key=").append(key).append(", value=").append(value).append("]");
		return builder.toString();
	}

}
