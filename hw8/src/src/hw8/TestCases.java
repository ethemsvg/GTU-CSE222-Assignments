package hw8;

import java.util.List;

public class TestCases implements Runnable {

    private  String FileName;
    private int X_SIZE;
    private int Y_SIZE;

    public TestCases(String FileName, int X_SIZE, int Y_SIZE) {
        this.FileName = FileName;
        this.X_SIZE = X_SIZE;
    	this.Y_SIZE = Y_SIZE;
    }



  
    
    public void test(){
    	
    	System.out.println("\n\n*******************\nMap is " + this.FileName + " with X_SIZE " + this.X_SIZE + " and Y_SIZE " + this.Y_SIZE + "\n********************\n");
        // THE X AND Y VALUES ARE COUNTED BY HELPER METHODS

        CSE222Map map = new CSE222Map(FileName);

        CSE222Graph graph = new CSE222Graph(map);

        CSE222Dijkstra dijkstraObj= new CSE222Dijkstra(graph);

        //long startTime = System.nanoTime();

        List<Coordinate> dijkstraPath = dijkstraObj.findPath();

        //long endTime = System.nanoTime();

        //System.out.println( FileName + "Dijkstra findPath() Elapsed Time: " + (endTime - startTime) / 1000  + "\n");


        CSE222BFS bfsObj= new CSE222BFS(graph);

        //startTime = System.nanoTime();

        List<Coordinate> bfsPath = bfsObj.findPath();

        //endTime = System.nanoTime();

        //System.out.println(FileName + "BFS findPath() Elapsed Time: " + (endTime - startTime) / 1000  + "\n");

        map.convertPNG();

        map.drawLine(dijkstraPath, FileName, "dijkstra");

        map.drawLine(bfsPath, FileName, "bfs");

        map.writePath(dijkstraPath,FileName,"dijkstra");

        map.writePath(bfsPath,FileName,"bfs");

        System.out.println("For " + FileName + ":");
        System.out.println("Dijkstra length: " + dijkstraObj.length);

        System.out.println("BFS length: " + bfsObj.length);

    }

    @Override
    public void run() {
        test();
    }
}

