package org.gmnz.leet;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<Integer> levels = new ArrayDeque<>();

        q.offer(root);
        levels.offer(0);
        int currentLevel = -1;
        ArrayList<Integer> levelNodes = null;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            int level = levels.poll();
            if (level != currentLevel) {
                levelNodes = new ArrayList<>();
                result.add(levelNodes);
                currentLevel = level;
            }
            levelNodes.add(n.val);
            if (n.left != null) {
                q.offer(n.left);
                levels.add(currentLevel + 1);
            }
            if (n.right != null) {
                q.offer(n.right);
                levels.add(currentLevel + 1);
            }
        }

        return result;
    }



    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
        System.out.println(lot.levelOrder(TreeNode.samplePostOrder()));
    }
}