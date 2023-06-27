package hw8;

import java.util.*;
/**
 * The CSE222Dijkstra class implements the Dijkstra's algorithm for finding the shortest path in a graph.
 */
public class CSE222Dijkstra {

    public CSE222Dijkstra(CSE222Graph graph){
        this.graph = graph;
    }
    /**
     * The graph on which the Dijkstra's algorithm will be applied.
     */
    protected CSE222Graph graph;
    /**
     * The length of the path found by the algorithm.
     */
    protected int length;
    /**
     * Finds the shortest path in the graph using Dijkstra's algorithm.
     *
     * @return a list of coordinates representing the shortest path
     */
    public List<Coordinate> findPath() {

        Coordinate startPoint =  new Coordinate(graph.startPoint.y, graph.startPoint.x);
        Coordinate endPoint =  new Coordinate(graph.endPoint.y, graph.endPoint.x);

        // Check if the graph contains the start and end points
        if (!graph.containsNode(startPoint) || !graph.containsNode(endPoint)) {
            return Collections.emptyList();
        }

        // Initialize the necessary data structures
        Map<Coordinate, Integer> distances = new HashMap<>();
        Map<Coordinate, Coordinate> previousNodes = new HashMap<>();

        // Creating a Priority Queue and setting a comparator for it to decide the priority of the nodes.
        PriorityQueue<Coordinate> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        Set<Coordinate> visitedNodes = new HashSet<>();

        // Initialize distances with a large value such as 999 (except the start node)
        for (Coordinate node : graph.adjacencyMap.keySet()) {
            distances.put(node, 999);
        }
        distances.put(startPoint, 0); // The start point distance must be the lowest.

        // Put the start node in the priority queue
        priorityQueue.offer(startPoint);

        // Dijkstra logic starts here:
        while (!priorityQueue.isEmpty()) {
            // Get the node with the smallest distance from the queue
            Coordinate current = priorityQueue.poll();

            if (current.equals(endPoint)) {
                break; // Found the destination, exit the loop
            }

            if (visitedNodes.contains(current)) {
                continue; // Already visited, skip to the next iteration
            }

            visitedNodes.add(current);

            // Get the neighboring nodes
            List<Coordinate> neighbors = graph.getNeighbourNodes(current);
            for (Coordinate neighbor : neighbors) {
                // Adding edge weight of 1 ( 1 is chosen arbitrarily, doesn't have any special meaning)
                int newDistance = distances.get(current) + 1;

                if (newDistance < distances.get(neighbor)) {
                    // Update the distance to the neighbor
                    distances.put(neighbor, newDistance);
                    // Update the previous node in the path
                    previousNodes.put(neighbor, current);
                    // Enqueue the neighbor
                    priorityQueue.offer(neighbor);
                }
            }
        }

        // This block iterates over the edges which lead from destination to source .
        List<Coordinate> shortestPath = new ArrayList<>();
        Coordinate current = endPoint;
        while (current != null) {
            shortestPath.add(current);
            current = previousNodes.get(current);
        }
        // Reversing the path so it is now from source to destination.
        Collections.reverse(shortestPath);
        this.length = shortestPath.size() -1 ;
        // the path is returned.
        return shortestPath;

    }

}
