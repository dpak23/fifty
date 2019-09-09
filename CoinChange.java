package fiftyquestions;

public class CoinChange {

    public int coinChange(int [] coins, int value){
        if(coins == null || coins.length == 0) throw new IllegalArgumentException();
        if(value == 0) return 0;
        int min = value;
        for(int coin : coins){
            if(value-coin >= 0){
                int c = coinChange(coins, value-coin);
                if(min > c + 1) min = c + 1;
            }
        }
        return min;
    }

    public int coinChangeDynamic(int [] coins, int value) {
        if(coins == null || coins.length == 0) throw new IllegalArgumentException();
        int [] cache = new int [value];
        for(int i = 1; i < cache.length; ++i) {
            cache[i] = -1;
        }
        return coinChangeDynamic(coins, value, cache);
    }

    public int coinChangeDynamic(int [] coins, int x, int [] cache){
        if(x == 0) return 0;
        int min = x;
        for(int coin : coins){
            if(x-coin >= 0){
                int c;
                if(cache[x-coin] >= 0) {
                    c = cache[x-coin];
                }
                else {
                    c = coinChangeDynamic(coins, x-coin, cache);
                    cache[x-coin] = c;
                }
                if(min > c + 1) min = c + 1;
            }
        }
        return min;
    }
}
