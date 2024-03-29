package lc222ak;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

public class MyBFS<E> implements BFS<E> {
    /**
     * @param graph
     * @param root
     * @return - List of nodes in BFS order
     */
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        if (graph == null || root == null) {
            throw new RuntimeException("Graph or root is null");
        }

        Queue<Node<E>> nodes = new ArrayDeque<>();
        nodes.add(root);

        return runBFS(nodes);
    }

    /**
     * @param graph
     * @return - List of nodes in BFS order
     */
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        if (graph == null) {
            throw new RuntimeException("Graph is null");
        }

        Queue<Node<E>> nodes = new ArrayDeque<>();

        for (Node<E> n : graph) {
            nodes.add(n);
        }

        return runBFS(nodes);
    }

    /**
     * @param nodesToRun - List of nodes that will be iterated over
     * @return - List of nodes
     */
    private List<Node<E>> runBFS(Queue<Node<E>> nodesToRun) {
        List<Node<E>> nodes = new ArrayList<>();
        Set<Node<E>> visited = new HashSet<>();

        while (!nodesToRun.isEmpty()) {
            Node<E> node = nodesToRun.remove();
            if (!visited.contains(node)) {
                visited.add(node);
                nodes.add(node);
                node.num = visited.size();
                for (Iterator<Node<E>> successors = node.succsOf(); successors.hasNext(); ) {
                    Node<E> succ = successors.next();
                    if (!visited.contains(succ)) {
                        nodesToRun.add(succ);
                    }
                }
            }
        }
        return nodes;
    }
}
