import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SaveHrefs extends RecursiveTask<List<String>>
{
    private String path;
    private String pathStart;
    public SaveHrefs(String path, String pathStart)
    {
        this.path = path;
        this.pathStart = pathStart;
    }

    @Override
    protected List<String> compute() {
        Document document = null;
        List<String> hrefsMass = new ArrayList<>();
        hrefsMass.add("");

        try {
            document = Jsoup.connect(path)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.19582")
                    .referrer("http://www.google.com")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert document != null;
        Elements hrefs = document.select("div a");
        for(Element href : hrefs) {
            if (!href.attr("href").toString().equals("")) {
                String a = href.attr("href").toString();

            if (a.charAt(0) == '/') {
                boolean flag = false;
                String newPath = path +"/" + a.replace("/", "");

                for(String str : hrefsMass)
                {
                    if(str.contains(a))
                    {
                        flag = true;
                    }
                }
                if(!flag) {
                    hrefsMass.add(newPath);
                    SaveHrefs task = new SaveHrefs(newPath, pathStart);
                    task.fork();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                 if(a.contains(pathStart))
                 {
                     boolean flag = false;
                     String newPath = a;
                     for(String str : hrefsMass)
                     {
                         if(str.contains("/" + a.split("/")[a.split("/").length - 1] + "/"))
                         {
                             flag = true;
                         }
                     }
                     if(!flag) {
                         if(newPath.substring(newPath.length() - 1).equals("/"))
                         {
                             newPath = newPath.substring(0, newPath.length() - 1);
                         }
                         hrefsMass.add(newPath);

                         SaveHrefs task = new SaveHrefs(newPath, pathStart);
                         task.fork();
                         try {
                             Thread.sleep(300);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
                }
            }
        }

        return hrefsMass;
    }
}
