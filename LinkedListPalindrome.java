package fiftyquestions;

import java.util.Stack;

public class LinkedListPalindrome {

    private class Node {
        private Node next;
        private int value;
    }

    public boolean isPalindrome(Node n){
        if(n == null) return false;
        Stack<Integer> s = new Stack<>();
        Node current = n;
        Node runner = n;
        while(runner != null && runner.next != null){
            s.push(current.value);
            current = current.next;
            runner = runner.next.next;
        }
        if(runner != null) current = current.next;
        while(current != null){
            if(s.pop().intValue() != current.value) return false;
            current = current.next;
        }
        return true;
    }
}
