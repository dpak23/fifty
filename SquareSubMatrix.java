package fiftyquestions;

public class SquareSubMatrix {

    public int squareSubMatrix(boolean [][] m){
        if(m == null || m.length == 0 || m[0].length == 0) return 0;
        int max = 0;
        int [][] cache = new int [m.length][m[0].length];

        for(int i = 0; i < m.length; ++i){
            for(int j = 0; j < m[0].length; ++j){
                if(i ==0 || j == 0) cache[i][j] = m[i][j]? 1 : 0;
                else if(m[i][j]){
                    cache[i][j] = Math.min(Math.min(cache[i-1][j], cache[i][j-1]), cache[i-1][j-1] + 1);
                }
                if(cache[i][j] > max) max = cache[i][j];
            }
        }
        return max;
    }
}
