package hw8;

import java.util.*;
/**
 * This class implements the Breadth First Search (BFS) algorithm for finding the shortest path
 * in a given graph represented by the CSE222Graph class.
 */
public class CSE222BFS {

    public CSE222BFS(CSE222Graph graph){
        this.graph = graph;
    }

    /**
     * The graph on which the BFS algorithm will be applied.
     */
    protected CSE222Graph graph;
    /**
     * The length of the shortest path found by the BFS algorithm.
     */
    protected int length;
    /**
     * Finds the shortest path in the graph using the Breadth First Search (BFS) algorithm.
     *
     * @return A list of Coordinate objects representing the shortest path from the source to the destination.
     *         The path is ordered from the source node to the destination node.
     */
    protected List<Coordinate> findPath(){
        // Initializing the source and destination Nodes(Coordinate objects).
        Coordinate source =  new Coordinate(graph.startPoint.y, graph.startPoint.x);
        Coordinate destination =  new Coordinate(graph.endPoint.y, graph.endPoint.x);

        // Map to store node, previous node pairs.
        // The algorithm basically performs a breadth first search to find all shortest paths to all nodes from the
        // source node. The algorithm stops searching when it comes across the destination node.
        // Then, it uses the previousNodes map to go back from the last element(destination node) to first element
        // (source node), iterating over the elements and adding them to a list. This list represents the path in a
        // reversed way, from destination to source. Lastly, we reverse this list to get the path from source to
        // destination, and return the reversed list.
        Map<Coordinate, Coordinate> previousNodes = new HashMap<>();

        // Queue to store the nodes to be visited.
        Queue<Coordinate> queue = new LinkedList<>();
        // Set to keep track of visited nodes.
        Set<Coordinate> visited = new HashSet<>();

        // Adding the source node to the queue
        queue.offer(source);
        // Marking the source node visited since it is the first node
        visited.add(source);

        // The BFS (Breadth First Search) Logic starts here:
        while (!queue.isEmpty()) {
            // Get the next node from the queue
            Coordinate current = queue.poll();
            // Check if the current node is the destination
            if (current.equals(destination)) {
                break;  // If the destination is found, exit the loop
            }
            // Gets the neighboring nodes of the current node
            List<Coordinate> neighbors = this.graph.getNeighbourNodes(current);
            for (Coordinate neighbor : neighbors) {
                // Check if the neighbor has not been visited before
                if (!visited.contains(neighbor)) {
                    // Add the neighbor to the queue and mark it as visited
                    queue.offer(neighbor);
                    visited.add(neighbor);

                    // Store the previous node for the neighbor to go from destination to source, (to construct the path)
                    previousNodes.put(neighbor, current);
                }
            }
        }

        // This block iterates over the edges which lead from destination to source .
        List<Coordinate> shortestPath = new ArrayList<>();
        Coordinate current = destination;
        while (current != null) {
            shortestPath.add(current);
            current = previousNodes.get(current);
        }
        // Reversing the path so it is now from source to destination.
        Collections.reverse(shortestPath);

        this.length = shortestPath.size() - 1;

        // the path is returned.
        return shortestPath;

    }


}
