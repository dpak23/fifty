package fiftyquestions;

public class ReverseLinkedList {
    private class Node {
        int value;
        Node next;
    }

    public void reverseLinkedList(Node root){
        if(root == null) return;
        reverseLinkedList(root.next);
        System.out.println(root.value);
    }
}
