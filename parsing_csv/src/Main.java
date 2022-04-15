import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args) {
        String path = "file/movementList.csv";
        List<String> File;
        File = Parsing(path);

        System.out.println("Сумма доходов: " + RUR_profit(File));

        System.out.println("Сумма расходов: " + RUR_loss(File));

        System.out.println("Общий расход: ");
        Loss_Organization(File);

    }

    public static List<String> Parsing(String path)
    {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(path));
            lines.remove(0);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


        return lines;
    }

    public static double RUR_profit(List<String> file)
    {
        Boolean RUR = false;
        double profit = 0;
        for (String str : file)
        {
            String[] words = str.split(",");
            for (String word : words)
            {
                if( word.equals("RUR"))
                {
                    RUR = true;
                }
            }
            if(RUR == true) {
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(words[words.length - 2]);
                matcher.find(0);
                profit += Double.parseDouble(words[words.length - 2].substring(matcher.start(), matcher.end()));
                RUR = false;
            }
        }
        return profit;
    }

    public static double RUR_loss(List<String> file)
    {
        Boolean RUR = false;
        double loss = 0;
        for (String str : file)
        {
            String[] words = str.split(",");
            for (String word : words)
            {
                if( word.equals("RUR"))
                {
                    RUR = true;
                }
            }
            if(RUR == true) {
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(words[words.length - 1]);
                //profit += Double.valueOf(words[words.length - 2]);
                matcher.find(0);
                loss += Double.parseDouble(words[words.length - 1].substring(matcher.start(), matcher.end()));
                RUR = false;
            }
        }
        return loss;
    }

    static public void Loss_Organization(List<String> file)
    {
        int count = 0;
        String[] str;
        String[] account;
        String ordganiz;
        boolean organiz_stay = true;
        List<String> list_organize = new ArrayList<>();
        for (String i : file)
        {
            str = i.split(",");
            account = str[5].split("\s{3,}");
            account[1] = account[1].replace('\\', '/');
            ordganiz = account[1].substring(account[1].indexOf("/"));
            if(list_organize.size() == 0)
            {
                list_organize.add(ordganiz);
            }
            for (String strok: list_organize)
            {
                if(!ordganiz.equals(strok))
                {
                    count ++;

                }
                else
                {
                    count = 0;
                    break;
                }
                if(count == list_organize.size())
                {
                    organiz_stay = false;
                    count = 0;

                }
            }
            if(organiz_stay == false)
            {
                list_organize.add(ordganiz);
                organiz_stay = true;
            }

        }
        for(String k : list_organize)
        {
            double profit = 0;
            double loss = 0;
             for (String i : file )
             {
                 i = i.replace('\\', '/');

                 if(i.contains(k))
                 {
                     List<String> prof = new ArrayList<>();
                     prof.add(i);
                     profit += RUR_profit(prof);
                     loss += RUR_loss(prof);

                 }
             }
            System.out.println(k + " Profit = " + profit + "\n" + "Loss = " + loss );
        }


    }
}


