package fiftyquestions;

import java.util.Stack;

public class InorderTraversalWithoutRecursion {

    class Node {
        Node left;
        Node right;
        int value;
    }

    public static void inOrderTraversal (Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        addLeftToStack(stack, root);
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.value);
            addLeftToStack(stack, current.right);
        }
    }

    private static void addLeftToStack(Stack stack, Node n){
        while(n != null){
            stack.push(n);
            n = n.left;
        }
    }
}

