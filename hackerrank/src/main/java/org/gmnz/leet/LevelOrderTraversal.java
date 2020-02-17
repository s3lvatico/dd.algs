package org.gmnz.leet;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<Integer> levels = new ArrayDeque<>();

        q.offer(root);
        levels.offer(0);
        int currentLevel = 0;
        ArrayList<Integer> ll = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            ll.add(n.val);
            if (n.left != null) {
                q.offer(n.left);
            }
            if (n.right != null) {
                q.offer(n.right);
            }
        }

        result.add(ll);
        return result;
    }



    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
        System.out.println(lot.levelOrder(TreeNode.samplePostOrder()));
    }
}