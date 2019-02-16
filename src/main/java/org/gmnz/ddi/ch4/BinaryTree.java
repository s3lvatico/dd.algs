package org.gmnz.ddi.ch4;


import java.util.Collection;


public interface BinaryTree<T> {

	static class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
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
			if (value == null) {
				if (other.value != null) {
					return false;
				}
			}
			else
				if (!value.equals(other.value)) {
					return false;
				}
			return true;
		}


	}

	enum Traversal {
		PRE_ORDER, IN_ORDER, POST_ORDER
	}



	void display(Traversal traversal);



	Collection<Node<T>> nodes();



	Node<T> find(T t);



	void build(T[] keys);



	boolean isEmpty();

}
