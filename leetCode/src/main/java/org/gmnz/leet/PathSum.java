package org.gmnz.leet;

public class PathSum {

   boolean hasPathSum(TreeNode root, int sum) {
      if (root == null)
         return false;
      if (root.left == null && root.right == null)
         return sum - root.val == 0;
      else
         return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
   }



   public static void main(String[] args) {
      PathSum ps = new PathSum();
      System.out.println(ps.hasPathSum(TreeNode.samplePathSum(), 22));
   }
}