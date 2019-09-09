package fiftyquestions;

public class Stacks {
    int[] topOfStacks;
    int[] nextIndex;
    int[] stackData;
    int nextAvailable;

    public Stacks(int capacity, int numberOfStacks){
        topOfStacks = new int [numberOfStacks];
        nextIndex = new int [capacity];
        stackData = new int [capacity];

        for(int i = 0; i < numberOfStacks; ++i) topOfStacks[i] = -1;
        for(int i = 0; i < capacity - 1; ++i){
            nextIndex[i] = i + 1;
        }
        nextIndex[capacity - 1] = -1;
        nextAvailable = 0;
    }

    public void push(int stack, int value){
        if(stack < 0 || stack >= topOfStacks.length) throw new IllegalArgumentException();
        if(nextAvailable < 0) return;

        int currentIndex = nextAvailable;
        nextAvailable = nextIndex[currentIndex];
        stackData[currentIndex] = value;
        nextIndex[currentIndex] = topOfStacks[stack];
        topOfStacks[stack] = currentIndex;
    }

    public int pop(int stack){
        if(stack < 0 || stack >= topOfStacks.length || topOfStacks[stack] < 0) throw new IllegalArgumentException();

        int currentIndex = topOfStacks[stack];
        int value = stackData[currentIndex];
        topOfStacks[stack] = nextIndex[currentIndex];
        nextIndex[currentIndex] = nextAvailable;
        nextAvailable = currentIndex;
        return value;
    }
}