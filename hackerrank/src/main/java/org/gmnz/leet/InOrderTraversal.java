package org.gmnz.leet;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InOrderTraversal {

   public List<Integer> scan(TreeNode root) {
      if (root == null) {
         return new ArrayList<>();
      }

      Deque<TreeNode> stack = new ArrayDeque<>();
      // Set<TreeNode> visited = new HashSet<>();
      List<Integer> values = new ArrayList<>();

      TreeNode n = root;

      while (!stack.isEmpty() || n != null) {
         if (n != null) {
            stack.push(n);
            n = n.left;
         } else {
            n = stack.pop();
            values.add(n.val);
            n = n.right;
         }
         /*
          * if (!visited.contains(n)) { if (n.left != null) { stack.push(n);
          * visited.add(n); n = n.left; } else { values.add(n.val); n = n.right != null ?
          * n.right : stack.pop(); } } else { n = n.right; }
          */

      }
      return values;

   }



   public static void main(String[] args) {
      InOrderTraversal iot = new InOrderTraversal();
      System.out.println(iot.scan(TreeNode.sampleTree()));
   }

}