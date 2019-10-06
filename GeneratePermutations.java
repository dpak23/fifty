package fiftyquestions;

import java.util.ArrayList;

public class GeneratePermutations {

    public ArrayList<String> generateStringPermutations(String str){
        ArrayList<String> results = new ArrayList<>();
        permutationsString("", str, results);
        return results;
    }
    private void permutationsString(String prefix, String suffix, ArrayList<String> results){
        if(suffix.length() == 0){
            results.add(prefix);
        } else {
            for(int i = 0; i < suffix.length(); ++i){
                permutationsString(prefix+suffix.charAt(i), suffix.substring(0,i) + suffix.substring(i+1, suffix.length()), results);
            }
        }
    }

    public ArrayList<int []> generateIntegerArrayPermutations(int [] a){
        ArrayList<int []> results = new ArrayList<>();
        permutationsInt(0, a, results);
        return results;
    }
    private void permutationsInt(int start, int [] a, ArrayList<int[]> results){
        if(start >= a.length){
            results.add(a.clone());
        } else {
            for(int i = start; i < a.length; ++i){
                swap(a, start, i);
                permutationsInt(start+1, a, results);
                swap(a, start, i);
            }
        }
    }

    private void swap(int[]a, int source, int destination){
        int temp = a[source];
        a[source] = a[destination];
        a[destination] = temp;
    }
}
