package fiftyquestions;

public class SplitLinkedList {

    private class Node {
        Node next;
        int value;
    }

    public Node splitList(Node n) {
        if(n==null) return n;
        Node runner = n;
        Node fastRunner = n.next;
        while(fastRunner != null && fastRunner.next != null){
            runner = runner.next;
            fastRunner = fastRunner.next.next;
        }
        Node splitListNode = runner.next;
        runner.next = null;
        return splitListNode;
    }
}
