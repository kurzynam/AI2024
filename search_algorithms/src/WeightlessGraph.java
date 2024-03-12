import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class WeightlessGraph {
    protected Map<String, List<String>> graph;

    public WeightlessGraph(Map<String, List<String>> graph) {
        this.graph = graph;
    }
    public abstract List<String> findShortestPath(String start, String goal);

    public List<String> calculatePath(String start, String goal, boolean found, Map<String, String> parent) {
        if (!found) {
            return null;
        }
        List<String> shortestPath = new ArrayList<>();
        String current = goal;
        while (!current.equals(start)) {
            shortestPath.add(current);
            current = parent.get(current);
        }
        shortestPath.add(start);
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
