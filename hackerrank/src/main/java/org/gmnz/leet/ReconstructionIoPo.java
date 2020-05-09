package org.gmnz.leet;

public class ReconstructionIoPo {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        /*
            analizzando l'esempio posso capire subito alcune cose:
            1) l'ultimo elemento del PO è di certo la radice dell'albero
            2) il primo elemento del IO è sicuramente il la foglia più a sinistra
            3) l'ultimo elemento del IO è sicuramente la foglia più a destra

            poiché ho INORDER, posso supporre anche che nella sequenza se un nodo occupa un posto K, allora il posto
            K-1 ha il nodo o immediatamente nel sottoalbero sx o gli è superiore


            l'ultimo in PO è la radice dell'albero

            potrei anche pensare: trovata la radice dell'albero (dal postorder), il sottoalbero DESTRO
            si trova dal subarray destro rispetto al nodo trovato. dualmente immagino che il sottoalbero sinistro
            si trovi a partire dal subarray sinistro
        */
        return null; // TODO risolvi
    }



    public static void main(String[] args) {
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        int[] postorder = new int[] { 9, 15, 7, 20, 3 };
        ReconstructionIoPo r = new ReconstructionIoPo();
        System.out.println(r.buildTree(inorder, postorder));
    }

}