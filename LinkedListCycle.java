package fiftyquestions;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    private class Node {
        Node next;
        int value;
    }

    public boolean isCyclicRegular (Node n){
        if(n == null) throw new IllegalArgumentException();
        Set<Node> nodes = new HashSet<>();
        Node runner = n;
        while(runner != null){
            if(nodes.contains(runner)) return true;
            nodes.add(runner);
        }
        return false;
    }

    public boolean isCyclicFloyd(Node n){
        if(n == null) throw new IllegalArgumentException();
        Node slowRunner = n;
        Node fastRunner = n.next;
        while(fastRunner != null && fastRunner.next != null){
            if(slowRunner == fastRunner) return true;
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        return false;
    }
}
