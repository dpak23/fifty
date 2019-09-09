package fiftyquestions;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue primary = new LinkedList();
    private Queue secondary = new LinkedList();

    public void push(int value){
        secondary.add(value);
        while(!primary.isEmpty()){
            secondary.add(primary.remove());
        }
        Queue temp = primary;
        primary = secondary;
        secondary = temp;
    }

    public int pop(){
        if(primary.isEmpty()) throw new IndexOutOfBoundsException();
        return (int) primary.remove();
    }
}
