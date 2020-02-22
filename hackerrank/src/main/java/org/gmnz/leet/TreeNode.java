package org.gmnz.leet;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


class TreeNode {

   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int v) {
      val = v;
   }



   public String toString() {
      StringBuilder sb = new StringBuilder("(");
      sb.append(val).append(", ");
      sb.append(left != null ? "L" : ".");
      sb.append(right != null ? "R)" : ".)");
      return sb.toString();
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



   static TreeNode samplePathSum() {
      TreeNode root = new TreeNode(5);

      TreeNode t11 = new TreeNode(11);
      t11.left = new TreeNode(7);
      t11.right = new TreeNode(2);
      TreeNode t4_1 = new TreeNode(4);
      t4_1.right = new TreeNode(1);
      TreeNode t4_11 = new TreeNode(4);
      t4_11.left = t11;
      TreeNode t8 = new TreeNode(8);
      t8.left = new TreeNode(13);
      t8.right = t4_1;

      root.left = t4_11;
      root.right = t8;

      return root;
   }
}
