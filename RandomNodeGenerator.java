package fiftyquestions;

import java.util.Random;

public class RandomNodeGenerator {

    class Node {
        int value;
        Node left;
        Node right;
        int children;
    }

    private Node root;
    private Random rand = new Random();

    public int getRandomNode(){
        if(root == null) throw new RuntimeException();
        int count = rand.nextInt(root.children + 1);
        return getRandomNode(root, count);
    }

    private int getRandomNode(Node node, int count){
        if(count == getChildren(node.left)) return node.value;
        if(count < getChildren(node.left)) return getRandomNode(node.left, count);

        return getRandomNode(node.right, getChildren(node.left) - 1);

    }

    private int getChildren (Node node){
        if(node == null) return 0;
        return node.children + 1;
    }

}
