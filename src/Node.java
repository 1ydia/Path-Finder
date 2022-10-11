import java.util.Map;

public class Node {
    Map<String, Node> neighbours;
    public Node(Map<String, Node> neighbours) {
        this.neighbours = neighbours;
    }
}
