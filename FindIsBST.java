package fiftyquestions;

public class FindIsBST {

    class Node {
        Node left;
        Node right;
        int value;
    }


    public boolean isBST(Node root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max){
        if(root == null) return true;
        if(root.value < min || root.value > max) return false;
        return isBST(root.left, min, root.value) && isBST(root.right, root.value + 1, max);
    }
}
