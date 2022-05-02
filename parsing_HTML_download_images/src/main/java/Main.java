import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main
{

        private static String IMAGE_DESTINATION_FOLDER = "data/images";

        public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://lenta.ru/")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.19582")
                .referrer("http://www.google.com")
                .get();
        Elements img = document.select("div img");
        List<String> imgSrc = new ArrayList<>();
        for (Element i : img)
        {
                imgSrc.add(i.attr("src"));
                downloadImage(i.attr("src"));
        }
    }
        private static void downloadImage(String strImageURL){

                //get file name from image path
                String strImageName =
                        strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );
                System.out.println(strImageName);

                System.out.println("Saving: " + strImageName + ", from: " + strImageURL);

                try {

                        //open the stream from URL
                        URL urlImage = new URL(strImageURL);
                        InputStream in = urlImage.openStream();

                        byte[] buffer = new byte[4096];
                        int n = -1;

                        OutputStream os =
                                new FileOutputStream( IMAGE_DESTINATION_FOLDER + "/" + strImageName );

                        //write bytes to the output stream
                        while ( (n = in.read(buffer)) != -1 ){
                                os.write(buffer, 0, n);
                        }

                        //close the stream
                        os.close();

                        System.out.println("Image saved");

                } catch (IOException e) {
                        e.printStackTrace();
                }

        }
}
