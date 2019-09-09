package fiftyquestions;

public class StackWithMax {
    private class Node {
        Node next;
        Node oldMax;
        int value;
    }

    private Node stack;
    private Node max;

    public void push(int value){
        Node n = new Node();
        n.value = value;

        if(stack == null){
            stack = n;
        } else {
            n.next = stack;
            stack = n;
        }
        if(max == null || value > max.value){
            n.oldMax = max;
            max = n;
        }
    }

    public int pop(){
        if(stack == null) throw new IllegalStateException();
        Node n = stack;
        stack = stack.next;
        max = n.oldMax;
        return n.value;
    }
}
