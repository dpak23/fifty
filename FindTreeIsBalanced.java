package fiftyquestions;

public class FindTreeIsBalanced {

    class Node {
        Node left;
        Node right;
        int value;
    }

    Node root;
    public boolean isBalanced(Node root){
        return balancedHeight(root) > -1? true:false;
    }

    private int balancedHeight(Node root){
        if(root == null) return 0;
        int leftHeight = balancedHeight(root.left);
        int rightHeight = balancedHeight(root.right);
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(rightHeight - leftHeight) > 1) return -1;
        return leftHeight > rightHeight?leftHeight + 1: rightHeight + 1;
    }
}
