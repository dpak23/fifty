package fiftyquestions;

public class FibonnacciProducer {
    public static long fibonnacci(int x){
        if(x < 0) return -1;
        if(x == 0) return 0;
        long [] cache = new long [x + 1];
        for(int i = 1; i < cache.length; ++i) cache[i] = -1;
        cache[1] = 1;
        return fibonnacci(x, cache);
    }

    private static long fibonnacci(int x, long [] cache){
        if(cache[x] > -1) return cache[x];
        cache[x] = fibonnacci(x-1,cache) + fibonnacci(x - 2, cache);
        return cache[x];
    }

    public static void main(String[] args) {
        System.out.print(fibonnacci(1000));
    }
}
