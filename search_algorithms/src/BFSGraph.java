import java.util.*;

public class BFSGraph extends  WeightlessGraph{


    public BFSGraph(Map<String, List<String>> graph) {
        super(graph);
    }

    public List<String> findShortestPath(String start, String goal) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        boolean found = false;

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(goal)) {
                found = true;
                break;
            }
            List<String> neighbors = graph.getOrDefault(current, new ArrayList<>());
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }
        return calculatePath(start, goal, found, parent);
    }
}
