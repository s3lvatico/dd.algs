package org.gmnz.leet;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class PostOrderTraversal {

    List<Integer> traverse(TreeNode n) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> branches = new ArrayDeque<>();
        while (n != null) {
            int nb = 0;
            TreeNode x = null;
            if (n.right != null || n.left != null) {
                nodes.push(n);
            }
            if (n.right != null) {
                nb++;
                x = n.right;
                if (n.left != null) {
                    nodes.push(n.right);
                }
            }
            if (n.left != null) {
                nb++;
                x = n.left;
            }
            if (nb != 0) {
                branches.push(nb);
                n = x;
            } else {
                list.add(n.val);
                while (branches.peek() == 1) {
                    branches.pop();
                    list.add(nodes.pop().val);
                }
                branches.pop();
                n = nodes.pop();
                branches.push(1);
            }
        }
        return list;
    }



    public static void main(String[] args) {
        PostOrderTraversal pot = new PostOrderTraversal();
        System.out.println(pot.traverse(TreeNode.samplePostOrder()));
    }

}