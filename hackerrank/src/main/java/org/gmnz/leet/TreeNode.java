package org.gmnz.leet;

class TreeNode {

   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int v) {
      val = v;
   }



   static TreeNode sampleTree() {
      TreeNode tre = new TreeNode(3);
      TreeNode due = new TreeNode(2);
      due.left = tre;
      TreeNode uno = new TreeNode(1);
      uno.right = due;
      return uno;
   }
}
