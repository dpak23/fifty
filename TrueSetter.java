package fiftyquestions;

public class TrueSetter {

    public void setTrue (boolean [][] a){
        if(a == null || a.length == 0 || a[0].length == 0) return;
        boolean rowTrue = false;
        boolean colTrue = false;
        for(boolean b: a[0]){
            rowTrue |= b;
        }
        for(boolean [] b : a){
            colTrue |= b[0];
        }
        for(int i = 1; i < a.length; ++i){
            for(int j = 1; j < a[0].length; ++j){
                if(a[i][j]){
                    a[i][0] = true;
                    a[0][j] = true;
                }
            }
        }
        for(int i = 0; i < a[0].length; ++i){
            if(a[0][i]){
                trueCol(a, i);
            }
        }

        for(int i = 0; i < a.length; ++i){
            if(a[i][0]){
                trueRow(a, i);
            }
        }
        if(rowTrue){
            trueRow(a, 0);
        }
        if(colTrue){
            trueCol(a, 0);
        }
    }


    private void trueRow(boolean [][] a, int rowNum){
        for(int j = 0; j < a[0].length; ++j){
            a[rowNum][j] = true;
        }
    }
    private void trueCol(boolean [][] a, int colNum){
        for(int j = 0; j < a.length; ++j){
            a[j][colNum] = true;
        }
    }
}
