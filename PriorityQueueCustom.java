package fiftyquestions;

public class PriorityQueueCustom {
    int [] heap;
    int size;

    public PriorityQueueCustom(int maxSize){
        heap  = new int [maxSize];
        size = 0;
    }
  /* 0 -> 1, 2
     1 -> 3, 4
     2 -> 5, 6
     parent = (childPos + 1)/2 - 1
     leftchildren = (parentPostion * 2) + 1;
  */

    public void push(int value) {
        if(size == heap.length) throw new IllegalStateException();
        int pos = size;
        heap[pos] = value;
        while(pos > 0){
            int parent = (pos + 1)/2 - 1;
            if(heap[parent] >= heap[pos]) break;
            swapIndices(parent, pos);
            pos = parent;
        }
        size++;
    }

    public int pop(){
        if(size == 0) throw new IllegalStateException();
        int toReturn = heap[0];
        heap[0] = heap[size];
        int pos = 0;
        while(pos < size/2){
            int leftChild = (pos * 2) + 1;
            int rightChild = leftChild + 1;
            if(rightChild < size && heap[leftChild] < heap[rightChild]){
                if(heap[pos] >= heap[rightChild]) break;
                swapIndices(pos, rightChild);
                pos = rightChild;
            } else {
                if(heap[pos] >= heap[leftChild])break;
                swapIndices(pos, leftChild);
                pos = leftChild;
            }
        }
        size--;
        return toReturn;
    }

    private void swapIndices(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
