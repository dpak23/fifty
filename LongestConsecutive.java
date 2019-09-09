package fiftyquestions;

public class LongestConsecutive {
    private class Node {
        private int value;
        private Node left;
        private Node right;
    }

    public int longestConsecutive(Node node){
        return max(consecutive(node.left, node.value, 1), consecutive(node.right, node.value, 1));
    }

    private int consecutive(Node n, int prev, int lengthSoFar){
        if(n == null) return lengthSoFar;
        if(n.value == prev+1){
            int leftLength = consecutive(n.left, n.value, lengthSoFar + 1);
            int rightLength = consecutive(n.right, n.value, lengthSoFar + 1);
            return max(leftLength, rightLength);
        }
        int leftLength = consecutive(n.left, n.value, 1);
        int rightLength = consecutive(n.right, n.value, 1);
        return max(leftLength, rightLength, lengthSoFar);
    }

    private int max(int ... vals){
        int max = Integer.MIN_VALUE;
        for(int i : vals){
            if(i > max) max = i;
        }
        return max;
    }
}
