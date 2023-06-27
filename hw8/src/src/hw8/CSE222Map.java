package hw8;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * CSE222Map represents a map with coordinates and provides methods for map operations.
 */
public class CSE222Map {
    /**
     * The starting (source) point.
     */
    protected Coordinate startPoint = new Coordinate();
    /**
     * The end (destination) point.
     */
    protected Coordinate endPoint = new Coordinate();
    /**
     * Number of rows of the map.
     */
    protected int rowValue;
    /**
     * Number of columns of the map.
     */
    protected int columnValue;
    /**
     * Name of the source .txt file.
     */
    protected String filename;
    /**
     * A 2D array to store the map as a 2D matrix of 1s and 0s.
     */
    protected int[][] coordinatesMatrix;

    /**
     * Constructs a CSE222Map object.
     */
    public CSE222Map() {
    }

    /**
     * Constructs a CSE222Map object with the specified filename.
     *
     * @param filename the name of the file containing map data
     */
    public CSE222Map(String filename) {
        // The object is constructed and the necessary fields are filled.
        this.filename = filename;
        this.rowValue = fileRowCounter(filename);
        this.columnValue = fileColumnCounter(filename);
        this.coordinatesMatrix = new int[rowValue][columnValue];
        coordinatesMatrixFillerMethod(filename);
        sourceDestinationSetter(filename);
    }

    /**
     * Converts the map to a PNG image and saves it as a file.
     */
    protected void convertPNG() {
        // Gets the dimensions of the map from the 2D map matrix.
        int width = coordinatesMatrix[0].length;
        int height = coordinatesMatrix.length;

        // Creates a new BufferedImage with the specified width, height, and image type.
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Iterates over each pixel in the image and sets its color based on the map value.
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int value = coordinatesMatrix[y][x];
                int rgb = value == 1 ? 0x808080 : 0xFFFFFF; // Gray for 1, white for 0
                image.setRGB(x, y, rgb);
            }
        }

        // Writes the image to a file with the specified file name.
        try {
            ImageIO.write(image, "png", new File(filename + "generatedMapImage.png"));
        } catch (IOException e) {
            System.out.println("An error occurred while saving the image: " + e.getMessage());
        }
    }

    /**
     * Writes the given path coordinates to a text file.
     *
     * @param coordinates the list of coordinates representing the path
     * @param filename    the name of the file to write the path
     * @param type        the name of the algorithm that produced the path ( Dijkstra or BFS )
     */
    protected void writePath(List<Coordinate> coordinates, String filename, String type) {
        // Writes the coordinates of the path from the input list to a file.
        try {
            FileWriter fileWriter = new FileWriter(filename + "_" + type + "Path.txt");
            // Iterates over the coordinate values on the list and writes them to the file.
            for (Coordinate coordinate : coordinates) {
                String line = "(" + coordinate.x + "," + coordinate.y + ")" + "\n";
                fileWriter.write(line);
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred in writePath method.");
        }
    }

    /**
     * Draws a line on the generated map image using the given path coordinates.
     *
     * @param path     the list of coordinates representing the path
     * @param filename the name of the generated map image file
     * @param type     the name of the algorithm that produced the path ( Dijkstra or BFS )
     */
    protected void drawLine(List<Coordinate> path, String filename, String type) {
        try {
            // Opens the map png to read.
            BufferedImage image = ImageIO.read(new File(filename + "generatedMapImage.png"));
            // Iterates over the coordinates on the path list, and paints the corresponding pixel on the image red.
            for (Coordinate coordinate : path) {
                int x = coordinate.getX();
                int y = coordinate.getY();
                image.setRGB(y, x, Color.RED.getRGB());
            }
            // Generates a new file with the path on it.
            File outputFile = new File(filename + "_" + type + "Line.png");
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            System.out.println("An error occurred while processing the image: " + e.getMessage());
        }
    }

    /**
     * Fills the coordinates matrix with values read from the file.
     *
     * @param filename the name of the map file containing the coordinates
     */
    private void coordinatesMatrixFillerMethod(String filename) {
        // Fills the 2D int matrix with the values from the txt file.
        // Ignores first 2 lines since they do not hold map pixel values.
        try {
            int i, j;
            File ft = new File(filename);
            Scanner reader = new Scanner(ft);
            // The first two lines are skipped here.
            reader.nextLine();
            reader.nextLine();
            for (i = 0; i < fileRowCounter(filename); i++) {
                // Line is read and split using some regex.
                String rawLine = reader.nextLine();
                String line = rawLine.replaceAll("[()]", "");
                String[] elements = line.split(",");
                for (j = 0; j < elements.length; j++) {
                    coordinatesMatrix[i][j] = Integer.parseInt(elements[j]);
                }
            }
        } catch (IOException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }
    }

    /**
     * Returns the number of rows in the file with the given file name.
     *
     * @param fileName the name of the file to be counted
     * @return the number of rows in the file, or -1 if an error occurs
     */
    private int fileRowCounter(String fileName) {
        // Counts the number of rows in the file.
        // Reads the file line by line until EOF.
        try {
            int i = 0;
            File ft = new File(fileName);
            Scanner reader = new Scanner(ft);
            while (reader.hasNextLine()) {
                i++;
                reader.nextLine();
            }
            reader.close();
            // The -2 is because the first two lines of the txt file has coordinates, which are not a part of the map.
            return i - 2;
        } catch (IOException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }
        return -1;
    }

    /**
     * Returns the number of columns in the file with the given file name.
     *
     * @param fileName the name of the file to be counted
     * @return the number of columns in the file, or -1 if an error occurs
     */
    private int fileColumnCounter(String fileName) {
        // Counts the number of columns in the txt file.
        // Does it by counting the number of digits in the 3rd line (Since 1st and 2nd lines do not hold map values).
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            int lineCount = 0;
            while (reader.hasNextLine()) {
                lineCount++;
                String line = reader.nextLine();
                if (lineCount == 3) {
                    String[] elements = line.split(",");
                    reader.close();
                    return elements.length;
                }
            }

            reader.close();
            return -1; // If the file has fewer than 3 lines
        } catch (IOException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
            return -1;
        }
    }

    /**
     * Sets the start and end points from the file.
     *
     * @param fileName the name of the map file that contains the start and end points
     * @return 0 if successful, -1 if an error occurs
     */
    private int sourceDestinationSetter(String fileName) {
        // Parses the source and destination coordinates from the first two lines of the .txt file
        // And stores them for further use cases.
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            String line = reader.nextLine();
            String[] sourceValues = line.split(",");
            this.startPoint.y = Integer.parseInt(sourceValues[0]);
            this.startPoint.x = Integer.parseInt(sourceValues[1]);
            line = reader.nextLine();
            String[] destinationValues = line.split(",");
            this.endPoint.y = Integer.parseInt(destinationValues[0]);
            this.endPoint.x = Integer.parseInt(destinationValues[1]);

            reader.close();
        } catch (IOException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
            return -1;
        }
        return 0;
    }
}
