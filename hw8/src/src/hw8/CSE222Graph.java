package hw8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Represents a graph used for finding paths in CSE222 HW8.
 */
public class CSE222Graph {
    /**
     * Adjacency map of the graph, made of (Node, List of Neighbouring Nodes) pairs.
     */
    public HashMap<Coordinate, List<Coordinate>> adjacencyMap = new HashMap<>();
    /**
     * Constructs an empty CSE222Graph object.
     */
    public CSE222Graph(){

    }
    /**
     * Constructs a CSE222Graph object based on a CSE222Map.
     *
     * @param map the CSE222Map object to build the graph from
     */
    public CSE222Graph(CSE222Map map){
        this.startPoint.x = map.startPoint.x;
        this.startPoint.y = map.startPoint.y;
        this.endPoint.x = map.endPoint.x;
        this.endPoint.y = map.endPoint.y;

        // Iterates over the elements of the coordinatesMatrix of the map (which are 1s or 0s).
        // Adds them to the graph if one is 0, and checks if the surrounding elements are 0 too
        // to determine adjacency/edge relations

        for(int i=0;i<map.coordinatesMatrix.length;i++){

            for(int j=0;j<map.coordinatesMatrix[i].length;j++){
                if(map.coordinatesMatrix[i][j] == 0){
                    Coordinate newNode = new Coordinate(i,j);
                    addNode(newNode);

                    if(i>=1){
                        if(map.coordinatesMatrix[i-1][j] == 0 ){

                            Coordinate newAdjacentNode = new Coordinate(i-1,j);
                            addNode(newAdjacentNode);
                            addEdge(newNode,newAdjacentNode);
                        }

                        if(j<map.columnValue-1 && map.coordinatesMatrix[i-1][j+1] == 0 ){
                            Coordinate newAdjacentNode = new Coordinate(i-1,j+1);
                            addNode(newAdjacentNode);
                            addEdge(newNode,newAdjacentNode);
                        }

                        if(j>=1){
                            if(map.coordinatesMatrix[i-1][j-1] == 0 ){
                                Coordinate newAdjacentNode = new Coordinate(i-1,j-1);
                                addNode(newAdjacentNode);
                                addEdge(newNode,newAdjacentNode);
                            }
                        }
                    }

                    if(j>=1){
                        if(map.coordinatesMatrix[i][j-1] == 0){
                            Coordinate newAdjacentNode = new Coordinate(i,j-1);
                            addNode(newAdjacentNode);
                            addEdge(newNode,newAdjacentNode);
                        }
                        if(i<map.rowValue-1){ // turn 499 to a dynamic value according to the size of the txt
                            if(map.coordinatesMatrix[i+1][j-1] == 0 ){
                                Coordinate newAdjacentNode = new Coordinate(i+1,j-1);
                                addNode(newAdjacentNode);
                                addEdge(newNode,newAdjacentNode);
                            }
                        }

                    }

                    if(i<map.rowValue-1 && map.coordinatesMatrix[i+1][j] == 0 ){
                        Coordinate newAdjacentNode = new Coordinate(i+1,j);
                        addNode(newAdjacentNode);
                        addEdge(newNode,newAdjacentNode);
                    }

                    if(j<map.columnValue-1 && map.coordinatesMatrix[i][j+1] == 0 ){
                        Coordinate newAdjacentNode = new Coordinate(i,j+1);
                        addNode(newAdjacentNode);
                        addEdge(newNode,newAdjacentNode);
                    }
                    if(i<map.rowValue-1 && j<map.columnValue-1 && map.coordinatesMatrix[i+1][j+1] == 0 ){
                        Coordinate newAdjacentNode = new Coordinate(i+1,j+1);
                        addNode(newAdjacentNode);
                        addEdge(newNode,newAdjacentNode);
                    }


                }
            }

        }

    }
    /**
     * The starting (source) point.
     */
    protected Coordinate startPoint = new Coordinate();
    /**
     * The end (destination) point.
     */
    protected Coordinate endPoint = new Coordinate();

    /**
     * Adds a node to the graph.
     *
     * @param newNode the coordinate of the node to add
     */
    protected void addNode(Coordinate newNode){
        if (!adjacencyMap.containsKey(newNode)) {
            adjacencyMap.put(newNode, new ArrayList<>());
        }
    }
    /**
     * Adds an edge between two nodes in the graph.
     *
     * @param sourceNode      the source node of the edge
     * @param destinationNode the destination node of the edge
     */
    protected void addEdge(Coordinate sourceNode, Coordinate destinationNode){
        // If the nodes exist in the graph:

        if(adjacencyMap.containsKey(sourceNode) && adjacencyMap.containsKey(destinationNode)){
            if(!adjacencyMap.get(sourceNode).contains(destinationNode) && !adjacencyMap.get(destinationNode).contains(sourceNode)){
                adjacencyMap.get(sourceNode).add(destinationNode);
                adjacencyMap.get(destinationNode).add(sourceNode);
            }
        }
    }
    /**
     * Returns the neighboring nodes of a given node.
     *
     * @param node the node to get the neighbors of
     * @return a list of neighboring nodes
     */
    protected List<Coordinate> getNeighbourNodes(Coordinate node){

        List<Coordinate> neighbours = adjacencyMap.get(node);

        return neighbours;
    }
    /**
     * Prints the adjacency map of the graph for debugging purposes.
     */
    private void printAdMap(){
        // Iterates over the adjacency list
        for (Map.Entry<Coordinate, List<Coordinate>> entry : adjacencyMap.entrySet()) {
            Coordinate key = entry.getKey();
            List<Coordinate> value = entry.getValue();
            // Prints the node, adjacent nodes in the adjacency list format with arrows.
            System.out.print("Key: " + key + ", Value: " );

            for (Coordinate adjNode : value) {
                System.out.print(adjNode + " -> ");
            }
            System.out.println();
        }
    }
    /**
     * Checks if the graph contains a specific node.
     *
     * @param sourceNode the node to check
     * @return true if the node exists in the graph, false otherwise
     */
    protected boolean containsNode(Coordinate sourceNode){
        return adjacencyMap.containsKey(sourceNode);
    }

}
