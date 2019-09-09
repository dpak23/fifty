package fiftyquestions;

public class MatrixProduct {

    public int matrixProduct(int [][] a){
        if(a == null || a.length == 0 || a[0].length == 0) return 0;
        int[][] maxCache = new int[a.length][a[0].length];
        int[][] minCache = new int[a.length][a[0].length];
        int maxValue = 0;
        int minValue = 0;

        for(int i=0;i<a.length;++i){
            for(int j=0; j<a[0].length;++j){
                if(i ==0 && j == 0){
                    maxValue = a[i][j];
                    minValue = a[i][j];
                }
                if(i > 0){
                    int tempMaxValue = Math.max(a[i][j] * maxCache[i-1][j], a[i][j] * minCache[i-1][j]);
                    maxValue = Math.max(tempMaxValue, maxValue);
                    int tempMinValue = Math.min(a[i][j] * maxCache[i-1][j], a[i][j] * minCache[i-1][j]);
                    minValue = Math.min(tempMinValue, minValue);
                }
                if(j > 0){
                    int tempMaxValue = Math.max(a[i][j] * maxCache[i][j-1], a[i][j] * minCache[i][j-1]);
                    maxValue = Math.max(tempMaxValue, maxValue);
                    int tempMinValue = Math.min(a[i][j] * maxCache[i][j-1], a[i][j] * minCache[i][j-1]);
                    minValue = Math.min(tempMinValue, minValue);
                }
                maxCache[i][j] = maxValue;
                minCache[i][j] = minValue;
            }
        }
        return maxCache[a.length - 1][a[0].length - 1];
    }
}
