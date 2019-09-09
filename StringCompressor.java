package fiftyquestions;

public class StringCompressor {
    private static String compressString (String str) {
        if(str == null || str.length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < str.length() - 1; ++i){
            if(str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                sb.append(str.charAt(i)).append(count);
                count = 1;
            }
        }
        sb.append(str.charAt(str.length() - 1)).append(count);
        return sb.toString().length() < str.length()? sb.toString(): str;
    }

    public static void main(String[] args) {
        System.out.print(compressString("aaaabbbccccd"));
    }
}
