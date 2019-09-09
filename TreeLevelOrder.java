package fiftyquestions;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrder {
    private class Node {
        Node left;
        Node right;
        int value;
    }

    public void treeLevelOrderPrint(Node treeNode) {
        if (treeNode == null) return;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(treeNode);

        while (!nodes.isEmpty()) {
            Node popped = nodes.remove();
            System.out.println(popped.value);
            if (popped.left != null) nodes.add(popped.left);
            if (popped.right != null) nodes.add(popped.right);
        }
    }
}
