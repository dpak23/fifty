package fiftyquestions;

public class LongestCommonSubsequence {

    public static String longestCommonSubsequence (String a, String b){
        if(a.length() == 0) return a;
        if(b.length() == 0) return b;
        StringBuilder sb = new StringBuilder();
        int [][] cache = new int[a.length() + 1][b.length() + 1];
        for(int i = 0; i < a.length(); ++i){
            int cri = i + 1;
            for(int j = 0; j < b.length(); ++j){
                int cci = j + 1;
                if(a.charAt(i) == b.charAt(j)) {
                    cache[cri][cci] = cache[cri-1][cci-1] + 1;
                } else {
                    cache[cri][cci] = Math.max(cache[cri-1][cci], cache[cri][cci-1]);
                }
            }
        }
        int count = cache[a.length()][b.length()];
        int i = a.length();
        int j = b.length();
        while(count > 0){
            if(cache[i][j] == cache[i-1][j]) {
                i--;
            } else if(cache[i][j] == cache[i][j-1]){
                j--;
            } else {
                sb.append(b.charAt(j-1));
                i--;
                j--;
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(longestCommonSubsequence("longest", "stone"));
    }
}
