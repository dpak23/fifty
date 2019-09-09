package fiftyquestions;

public class AllUnique {

    public boolean allUnique(String str) {
        boolean [] exist = new boolean[1<<8];
        for(int i =0; i < str.length(); ++i){
            if(exist[str.charAt(i)]) return false;
            exist[str.charAt(i)] = true;
        }
        return true;
    }
}
