package fiftyquestions;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesLinkedList {

    private class Node {
        Node next;
        int value;
    }
    public void removeDuplicates(Node n) {
        if(n == null) return;
        Set<Node> nodes = new HashSet<>();
        Node runner = n;
        Node prev = null;
        while(runner != null){
            if(nodes.contains(runner)){
                prev.next = runner.next;
            } else {
                nodes.add(runner);
                prev = runner;
            }
            runner = runner.next;
        }
        prev.next = null;
    }

    public void removeDuplicatesConstantSpace(Node n){
        if(n == null) return;
        Node current = n;
        while(current != null){
            Node currentTwo = current;
            while(currentTwo.next != null){
                if(currentTwo.next.value == current.value){
                    currentTwo.next = currentTwo.next.next;
                }
                currentTwo = currentTwo.next;
            }
            current = current.next;
        }
    }
}
