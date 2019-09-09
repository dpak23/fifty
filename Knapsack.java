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
        for(int i = 1; i < items.length; ++i){
            for (int j = 0; j <= weight; ++j){
                if(items[i-1].weight > j) {
                    cache[i][j] = cache[i-1][j];
                }
                else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - items[i - 1].weight] + items[i-1].value);
                }
            }
        }
        return cache[items.length -1][weight];
    }
}
