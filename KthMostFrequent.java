package fiftyquestions;

import java.util.*;

public class KthMostFrequent {

    public static String kthMostFrequent (String [] strings, int k){
        if(strings == null || strings.length == 0) return null;
        Map<String, Integer> sMap = new HashMap<>();
        for(String s: strings){
            Integer count = sMap.get(s);
            if(count == null) count = 0;
            sMap.put(s, ++count);
        }
        List<Map.Entry> mapEntriesList = new ArrayList<>(sMap.entrySet());
        Collections.sort(mapEntriesList, (entry1, entry2) -> {
                Integer v1 = (Integer) entry1.getValue();
                Integer v2 = (Integer) entry2.getValue();
                return v2.compareTo(v1);
            }
        );
        if(mapEntriesList.size() > k) return (String) mapEntriesList.get(k).getKey();
        return null;

    }

    public static void main(String[] args) {
        String [] strings = {"a","b","c","a","b","a"};
        System.out.print(kthMostFrequent(strings, 0));
    }
}
