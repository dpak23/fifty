package fiftyquestions;

public class ElementExists {

    public static boolean elementExists(int [][] m, int x){
        int arrayIndex = -1;
        if(m[m.length - 1][m[m.length - 1].length - 1] < x) return false;
        for(int i = 0; i < m.length; ++i){
            int subArrayLength = m[i].length - 1;
            if(m[i][subArrayLength] > x) {
                arrayIndex = i;
                break;
            }
        }
        int [] subArrayToLook = m[arrayIndex];
        for(int i : subArrayToLook){
            if(i == x) return  true;
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] test = {{0, 6, 8, 9, 11},
                {20, 22, 28, 29, 31},
                {36, 38, 50, 61, 63},
                {64, 66, 100, 122, 128}};

        System.out.println(elementExists(test, 129));

    }
}
