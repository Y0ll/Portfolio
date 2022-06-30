package main.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class Main
{
    private static int newWidth = 200;
    private static int cores = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args)
    {

        String srcFolder = "start";
        String dstFolder = "end";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int sizeFile = files.length / cores;

        for (int i = 0; i < 12; i++)
        {
            File[] file1 = new File[sizeFile];
            System.arraycopy(files, i * sizeFile , file1, 0, file1.length);
            ImageThread resizer1 = new main.java.ImageThread(file1, dstFolder, newWidth);
            new Thread(resizer1).start();
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
