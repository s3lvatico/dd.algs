package org.gmnz.ddi.ch4;


public class NodeLevelsCount extends BasicBinaryTree<Integer> {

	private NodeRepository<Integer> repository;



	void populateRepository() {
		repository = new NodeRepository<Integer>();
		populateRepository(0, root);
	}



	private void populateRepository(int level, Node<Integer> node) {
		if (node == null) {
			return;
		}
		repository.addNode(level, node);
		populateRepository(level + 1, node.left);
		populateRepository(level + 1, node.right);
	}



	void showNodeLevels() {
		repository.display();
	}



	public static void main(String[] args) {
		NodeLevelsCount nlc = new NodeLevelsCount();
		nlc.build(new Integer[] { 1, 2, 3, 5, 8, 13, 21, 34, 55 });
		nlc.display(Traversal.PRE_ORDER);
		nlc.populateRepository();
		nlc.showNodeLevels();
	}
}
