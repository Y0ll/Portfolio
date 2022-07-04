import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main
{
    public static void main(String[] args) throws IOException {
        String path = "https://www.fl.ru";
        FileWriter file = new FileWriter("Files/href.txt");

        List<String> hrefs = new ForkJoinPool().invoke(new SaveHrefs(path, path));
        for (String str : hrefs)
        {
            String t = "";
            for (int i = 0; i < (str.split("/").length - 3); i++)
            {
                t += "\t";
            }
            file.write(t + str + "\n");
        }
        file.flush();

    }
}
