package org.gmnz.leet;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class InOrderTraversal {

   public List<Integer> scan(TreeNode root) {
      if (root == null) {
         return new ArrayList<>();
      }

      Deque<TreeNode> stack = new ArrayDeque<>();
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
      }
      return values;

   }



   public static void main(String[] args) {
      InOrderTraversal iot = new InOrderTraversal();
      System.out.println(iot.scan(TreeNode.sampleTree()));
   }

}