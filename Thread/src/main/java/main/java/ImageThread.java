package main.java;



import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;



public class ImageThread implements Runnable
{

    private File[] files;
    private String dstFolder;
    private int core;
    private int newWidth;

    public ImageThread(File[] files, String dstFolder, int newWidth) {
        this.files = files;
        this.dstFolder = dstFolder;
        this.newWidth = newWidth;
    }



    @Override
    public void run()
    {
        try
        {
            for(File file : files)
            {
                BufferedImage image = ImageIO.read(file);
                if(image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = new BufferedImage(
                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB
                );

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;


                newImage = Scalr.resize(image, 300);

//                for (int x = 0; x < newWidth; x++)
//                {
//                    for (int y = 0; y < newHeight; y++) {
//                        int rgb = image.getRGB(x * widthStep, y * heightStep);
//                        newImage.setRGB(x, y, rgb);
//                    }
//                }

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Done!");
    }


}
