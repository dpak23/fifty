package fiftyquestions;

import java.util.PriorityQueue;

public class ArraysMerger {
    private class QueueNode implements Comparable<QueueNode> {
        int arrayNum;
        int arrayIndex;
        int value;

        public QueueNode(int arrayNum, int arrayIndex, int value){
            this.arrayNum = arrayNum;
            this.arrayIndex = arrayIndex;
            this.value = value;
        }
        public int compareTo(QueueNode n){
            if(value > n.value) return 1;
            if(value < n.value) return -1;
            return 0;
        }
    }

    public int [] mergeKArrays(int[][] a){
        if(a == null || a.length == 0 || a[0].length == 0) return null;
        int resultArraySize = 0;
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        for(int i = 0; i < a.length; ++i){
            resultArraySize += a[i].length;
            if(a[i].length > 0){
                pq.add(new QueueNode(i, 0, a[i][0]));
            }
        }
        int [] result = new int [resultArraySize];
        int resultIndex = 0;
        while(!pq.isEmpty()){
            QueueNode poppedNode = pq.poll();
            result[resultIndex++] = poppedNode.value;
            int nextArrayIndex = poppedNode.arrayIndex + 1;
            if(nextArrayIndex < a[poppedNode.arrayNum].length){
                pq.add(new QueueNode(poppedNode.arrayNum, nextArrayIndex, a[poppedNode.arrayNum][nextArrayIndex]));
            }
        }
        return result;
    }
}
