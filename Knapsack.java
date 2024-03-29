package fiftyquestions;

public class Knapsack {

    class Item{
        int value;
        int weight;
    }

    public int knapsackRecursive(int weight, Item [] items){
        return knapsackRecursive(weight, items, 0);
    }

    private int knapsackRecursive(int w, Item [] items, int i){
        if(items == null || items.length == 0) return 0;
        if(i == items.length) return 0;

        if(w - items[i].weight < 0){
            knapsackRecursive(w, items, i+1);
        }
        return Math.max(knapsackRecursive(w - items[i].weight, items, i + 1) + items[i].value, knapsackRecursive(w, items, i+1));

    }

    public int knapsackDP(int weight, Item [] items){
        if(items == null || items.length == 0) return 0;

        int [][] cache = new int [items.length + 1][weight + 1];
        //Set first row and column to 0
        for(int i =0; i < cache[0].length;++i){
            cache[0][i] = 0;
        }
        for(int i =0; i < cache.length;++i){
            cache[i][0] = 0;
        }
        for(int row = 1; row < items.length; ++row){
            for (int col = 1; col <= weight; ++col){
                if(items[row - 1].weight > col) {
                    cache[row][col] = cache[row-1][col];
                } else {
                    cache[row][col] = Math.max(cache[row - 1][col], cache[row - 1][col - items[row - 1].weight] + items[row - 1].value);
                }
            }
        }
        return cache[items.length -1][weight];
    }
}
