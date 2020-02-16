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
            boolean isLeaf = n.left == null && n.right == null;
            if (isLeaf) {
                list.add(n.val);
                while (!branches.isEmpty() && branches.peek() == 1) {
                    branches.pop();
                    list.add(nodes.pop().val);
                }
                if (branches.isEmpty())
                    return list;
                branches.pop();
                n = nodes.pop();
                branches.push(1);
            } else {
                int nb = 0;
                TreeNode x = null;
                nodes.push(n);
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
                branches.push(nb);
                n = x;
            }
        }
        return list;
    }



    public static void main(String[] args) {
        PostOrderTraversal pot = new PostOrderTraversal();
        System.out.println(pot.traverse(TreeNode.samplePostOrder()));
    }

}