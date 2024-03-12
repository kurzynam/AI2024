import java.util.*;

public class DFSGraph extends WeightlessGraph{

    public DFSGraph(Map<String, List<String>> graph) {
        super(graph);
    }

    public List<String> findShortestPath(String start, String goal) {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        boolean found = false;

        stack.push(start);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (current.equals(goal)) {
                found = true;
                break;
            }
            if (!visited.contains(current)) {
                visited.add(current);
                List<String> neighbors = graph.getOrDefault(current, new ArrayList<>());
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                        parent.put(neighbor, current);
                    }
                }
            }
        }
        return calculatePath(start, goal, found, parent);
    }


}
