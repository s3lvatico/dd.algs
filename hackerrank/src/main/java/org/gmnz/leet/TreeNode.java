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



   static TreeNode samplePostOrder() {
      TreeNode f = new TreeNode(6);

      TreeNode b = new TreeNode(2);
      f.left = b;

      TreeNode a = new TreeNode(1);
      TreeNode d = new TreeNode(4);
      b.left = a;
      b.right = d;
      
      TreeNode c = new TreeNode(3);
      TreeNode e = new TreeNode(5);
      d.left = c;
      d.right = e;
      
      TreeNode h = new TreeNode(8);
      TreeNode i = new TreeNode(9);
      i.left = h;

      TreeNode g = new TreeNode(7);
      g.right = i;
      f.right = g;

      return f;
   }
}
