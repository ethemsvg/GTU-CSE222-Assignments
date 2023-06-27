package hw8;

import java.util.List;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String args[]){
        //  The X and Y sizes are calculated with some methods DYNAMICALLY ( I implemented them to make the program compatible with maps of any size).
        // ALSO, the output sometimes comes out mixed, the print order is corrupted because of the nature of multithreading,
        // since i don't know multithreading, there's nothing i can do to synchronize them. Thank you for evaluating my assignment.
        new Thread(new TestCases("Map01.txt", 500, 500)).start();
        new Thread(new TestCases("Map02.txt", 500, 500)).start();
        new Thread(new TestCases("Map03.txt", 500, 500)).start();
        new Thread(new TestCases("Map04.txt", 500, 500)).start();
        new Thread(new TestCases("Map05.txt", 500, 500)).start();
        new Thread(new TestCases("Map06.txt", 500, 500)).start();
        new Thread(new TestCases("Map07.txt", 500, 500)).start();
        new Thread(new TestCases("Map08.txt", 500, 500)).start();
        new Thread(new TestCases("Map09.txt", 500, 500)).start();
        new Thread(new TestCases("Map10.txt", 500, 500)).start();

    }
}