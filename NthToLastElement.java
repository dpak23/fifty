package fiftyquestions;

public class NthToLastElement {
    private class Node {
        Node next;
        int value;
    }

    public Node nthToLastElement(int n, Node node){
        if(node == null) return null;
        Node runner = node;
        for(int i = 0; i < n; ++i){
            if(runner == null) return null;
            runner = runner.next;
        }
        if(runner == null) return null;
        Node trailer = node;
        while(runner != null){
            runner = runner.next;
            trailer = trailer.next;
        }
        return trailer;
    }
}
