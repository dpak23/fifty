package fiftyquestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {

    class Node {
        List<Node> children;
    }

    public List<Node> shortestPath(Node start, Node destination){
        if(start == null || destination == null) return null;

        Queue<Node> toVisit = new LinkedList<>();
        HashMap<Node, Node> parents = new HashMap<>();

        toVisit.add(start);
        parents.put(start, null);

        while(!toVisit.isEmpty()) {
            Node current = toVisit.remove();
            if(current == destination) break;

            for(Node node : current.children){
                if(!parents.containsKey(node)){
                    toVisit.add(node);
                    parents.put(node, current);
                }
            }
        }

        if(!parents.containsKey(destination)) return null;

        List<Node> resultList = new LinkedList<>();
        Node traverser = destination;
        while(traverser != null){
            resultList.add(traverser);
            traverser = parents.get(traverser);
        }
        return resultList;
    }

}