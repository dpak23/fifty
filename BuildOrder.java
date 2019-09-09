package fiftyquestions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BuildOrder {

    public static List<Integer> buildOrder(int [][] a){
        if(a == null || a.length == 0) throw new IllegalArgumentException();
        Set<Integer> tempMarks = new HashSet<>();
        Set<Integer> permMarks = new HashSet<>();
        List<Integer> results = new LinkedList<>();
        for(int i = 0; i < a.length; ++i){
            if(!permMarks.contains(i)){
                visit(i, a, tempMarks, permMarks, results);
            }
        }
        return results;
    }

    private static void visit(int process,
                       int[][]a,
                       Set<Integer> tempMarks,
                       Set<Integer> permMarks,
                       List<Integer> results){
        if(tempMarks.contains(process)) throw new RuntimeException();

        if(!permMarks.contains(process)){
            tempMarks.add(process);
            for(int i : a[process]){
                visit(i, a, tempMarks, permMarks, results);
            }
            permMarks.add(process);
            tempMarks.remove(process);
            results.add(process);
        }

    }

    private class Item {
        char value;
        List<Item> dependencies;

        public char getValue() {
            return value;
        }

        public List<Item> getDependencies() {
            return dependencies;
        }
    }

    public static List<Character> buildOrder(List<Item> a){
        if(a == null || a.size () == 0) throw new IllegalArgumentException();
        Set<Item> tempMarks = new HashSet<>();
        Set<Item> permMarks = new HashSet<>();
        List<Character> results = new LinkedList<>();
        for(Item i : a){
            if(!permMarks.contains(i)){
                visit(i, a, tempMarks, permMarks, results);
            }
        }
        return results;
    }

    private static void visit(Item item,
                              List<Item> a,
                              Set<Item> tempMarks,
                              Set<Item> permMarks,
                              List<Character> results){
        if(tempMarks.contains(item)) throw new RuntimeException();

        if(!permMarks.contains(item)){
            tempMarks.add(item);
            for(Item i : item.getDependencies()){
                visit(i, a, tempMarks, permMarks, results);
            }
            permMarks.add(item);
            tempMarks.remove(item);
            results.add(item.getValue());
        }

    }

    public static void main(String[] args) {
        /*int [][] a = {         {},
                                {0},
                                {0},
                                {1,2},
                                {3}
                               }; */


        //System.out.println(buildOrder(a));
    }
}
