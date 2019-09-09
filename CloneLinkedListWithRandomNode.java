package fiftyquestions;

public class CloneLinkedListWithRandomNode {
    private class Node {
        Node next;
        Node random;
        int value;

        public Node (int value){
            this.value = value;
        }
    }

    public Node cloneLinkedList(Node n){
        if(n == null) return n;
        Node runner = n;
        Node newList = null;
        while(runner != null){
            Node newNode = new Node(runner.value);
            newNode.next = runner.next;
            runner.next = newNode;
            runner = runner.next.next;
            if(newList == null) newList = newNode;
        }
        runner = n;
        Node newListRunner = newList;
        while(newListRunner != null && runner != null){
            newListRunner.random = runner.random.next;
            runner.next = newListRunner.next;
            newListRunner.next = runner.next.next;
            runner = runner.next;
            newListRunner = newListRunner.next;
        }
        return newList;
    }
}
