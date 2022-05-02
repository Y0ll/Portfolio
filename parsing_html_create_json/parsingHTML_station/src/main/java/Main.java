import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main
{
    public static void main(String[] args) throws IOException {
        String path = "https://www.moscowmap.ru/metro.html#lines";
        File f = new File("data/index.html");
        Document document = Jsoup.parse(f, "UTF-8");


        Elements elements = document.select("span");
        File json = new File("data/map.json");
        FileWriter writer = new FileWriter(json);

        List<String> station = new ArrayList<>();
        writer.write("{\n \t" + "\"station\" : {\n");
        Boolean line_switch = false;
        for (Element i : elements)
        {
            if(!i.attr("data-line").equals("")) {
                line_switch = true;

                if(!i.attr("data-line").equals("1")) {
                    writer.write("\t\t],\n");
                }


                writer.write("\t\t"+ "\"" + i.attr("data-line") + "\"" + " : [\n");



            }
            if(i.attr("class").equals("name")) {

                writer.write("\t\t\t" + "\"" + i.select("span.name").text() + "\"");
                writer.write(",\n");

            }

        }


        writer.write("\t\t]" + "\n" + "\t}" + "\n}\n");
        writer.flush();
        writer.close();
        FileReader reader = new FileReader(json);
        BufferedReader br = new BufferedReader(reader);
        List<String> json_str = new ArrayList<>();

        String line = br.readLine();
        while (line != null) {

            json_str.add(line);

            line = br.readLine();

        }
        for (int i = 0; i < json_str.size(); i++)
        {
            if(json_str.get(i).contains("]"))
            {
                json_str.set(i - 1, json_str.get(i - 1).replace(',', ' '));

            }
        }

        FileWriter writer_end = new FileWriter(json);

        for (String str : json_str )
        {
            writer_end.write(str + "\n");
        }
        writer_end.flush();
        writer_end.close();

    }
}
