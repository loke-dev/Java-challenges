package lc222ak;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;

public class MyTransitiveClosure<E> implements TransitiveClosure<E> {
    /**
     * @param dg - graph
     * @return - map of transitive closures
     */
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
        MyDFS<E> dfs = new MyDFS<>();

        for (Node<E> node : dg) {
            map.put(node, dfs.dfs(dg, node));
        }

        return map;
    }
}
