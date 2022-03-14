import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args) {
        System.out.println("Введите путь к папки из которой копировать");
        String fistDirectory = new Scanner(System.in).nextLine();

        System.out.println("Введите папку куда копировать");
        String secondDirectory = new Scanner(System.in).nextLine();

        Fil( new File(fistDirectory), fistDirectory, secondDirectory);

    }

    public static void coppyFile(String fistDirectory,  String secondDirectory)
    {
        File startDirecroty  = new File(fistDirectory);
        File finishDirectory = new File(secondDirectory);



        InputStream is = null;
        OutputStream os = null;
        try {

            os = new FileOutputStream(finishDirectory);
            is = new FileInputStream(startDirecroty);

            byte[] buffer = new byte[1024];
            int length;

            while((length = is.read(buffer)) > 0)
            {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


    }

    public static void Fil(File file, String fistDirectory, String secondDirectory)
    {
        String secondDirectoryTwo = secondDirectory;
        String str;
        String second;
        try {
            List<String> massFiles = new ArrayList<>();
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println(f.getAbsolutePath());
                    str = f.getAbsolutePath();
                    str = str.replace("\\", "/");
                    str = str.replaceFirst(fistDirectory, "").trim();
                    second = secondDirectoryTwo + str;
                    Files.createDirectories(Path.of(second));
                    Fil(f, fistDirectory, secondDirectory);
                } else {
                    massFiles.add(f + "\n");

                }

            }

            for(String i : massFiles)
            {
                str = i;

                str = str.replace("\\", "/");
                str = str.replaceFirst(fistDirectory, "").trim();
                i = i.replace("\\", "/").trim();

                str = secondDirectory + str;

                coppyFile(i, str);

            }

        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
