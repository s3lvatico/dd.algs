package org.gmnz.leet;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class ReconstructionInPost {

   private Map<Integer, Integer> inOrderIndex;

   private int[] postorder;

   public TreeNode buildTree(int[] inorder, int[] postorder) {
      // this.inorder = inorder;
      this.postorder = postorder;

      // questa mappa è una "indexOf". uso una mappa sfruttando l'ipotesi dell'unicità
      // dei valori nei nodi
      inOrderIndex = new HashMap<>(inorder.length);
      Arrays.stream(inorder).forEach(n -> inOrderIndex.put(n, inOrderIndex.size()));

      return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
   }



   private TreeNode buildTree(int iLo, int iHi, int pLo, int pHi) {
      // condizione di terminazione: si incrociano gli indici
      if (iLo > iHi || pLo > pHi)
         return null;

      // il valore del nodo è sempre all'estremo destro del (sub)array di postorder
      int v = postorder[pHi];
      TreeNode n = new TreeNode(v);

      // indice del valore in esame nell'array
      int xv = inOrderIndex.get(v);

      // chiamata ricorsiva per il sottoalbero destro
      // il sottoalbero destro si trova nel subarray destro di inorder rispetto alla
      // posizione della chiave, e in un subarray di postorder immediatamente
      // precedente l'estremo destro, ampio quanto quello individuato per inorder
      n.right = buildTree(xv + 1, iHi, pHi - (iHi - xv), pHi - 1);

      // chiamata ricorsiva per il sottoalbero sinistro.
      // il sottoalbero sinistro si trova nel subarray sinistro dell'inOrder rispetto
      // alla posizione della chiave v, mentre nell'array di postOrder si trova nel
      // blocco antecedente quello del sottoalbero destro
      n.left = buildTree(iLo, xv - 1, pLo, pLo + (xv - 1 - iLo));

      return n;
   }



   public static void main(String[] args) {
      /*
       * TreeNode root = TreeNode.sampleReconstruction01(); System.out.println(root);
       * 
       * PostOrderTraversal post = new PostOrderTraversal();
       * System.out.println(post.traverse(root)); InOrderTraversal inorder = new
       * InOrderTraversal(); System.out.println(inorder.scan(root));
       */
      /*
       * int[] inOrder = new int[] { 7, 3, 5, 10, 15, 1, 9, 6, 11, 8, 13, 2, 12, 14, 4
       * }; int[] postOrder = new int[] { 3, 7, 15, 10, 9, 1, 5, 8, 11, 2, 14, 12, 4,
       * 13, 6 };
       */
      ReconstructionInPost reformation = new ReconstructionInPost();

      int[] inOrder = new int[] { 9, 3, 15, 20, 7 };
      int[] postOrder = new int[] { 9, 15, 7, 20, 3 };
      System.out.println(reformation.buildTree(inOrder, postOrder));

   }

}