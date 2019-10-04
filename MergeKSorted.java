package fiftyquestions;

import java.util.PriorityQueue;

public class MergeKSorted {

    //Time Complexity k*n * logk(Insertion into pq)
    private class QueueNode implements Comparable<QueueNode> {
        private int arrayIndex;
        private int indexInArray;
        private int value;
        @Override
        public int compareTo(QueueNode queueNode) {
            if(value > queueNode.value) return 1;
            if(value < queueNode.value) return -1;
            return 0;
        }
        public QueueNode(int arrayIndex, int indexInArray, int value){
            this.arrayIndex = arrayIndex;
            this.indexInArray = indexInArray;
            this.value = value;
        }
    }

    public int [] mergeSorted(int [][] k){
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        int size = 0;
        for(int i = 0; i < k.length; ++i) {
            size += k[i].length;
            if (k[i].length > 0) {
                pq.add(new QueueNode(i, 0, k[i][0]));
            }
        }
        int [] results = new int[size];
        for(int i = 0; !pq.isEmpty(); ++i){
            QueueNode n = pq.poll();
            results[i] = n.value;
            int newIndex = n.indexInArray + 1;
            if(newIndex <  k[n.arrayIndex].length){
                pq.add(new QueueNode(n.arrayIndex, newIndex, k[n.arrayIndex][newIndex]));
            }
        }
        return results;
    }
}
