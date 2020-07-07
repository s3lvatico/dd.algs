package org.gmnz.leet;


class BinaryTreeMaxDepth {

    int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }



    public static void main(String[] args) {
        System.out.println(new BinaryTreeMaxDepth().maxDepth(TreeNode.samplePostOrder()));
    }

}