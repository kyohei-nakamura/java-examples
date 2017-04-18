package kyo.example;

import java.util.ResourceBundle;
import java.util.Enumeration;
import java.io.File;
import org.supercsv.io.CsvListWriter;
import java.io.FileWriter;
import org.supercsv.prefs.CsvPreference;

public class App { 

    public static void main(String[] args) 
    {
        if (args.length != 1) {
            System.err.println("Usage: LoadProperties <properties_name>");
            System.exit(-1);
        }
        ResourceBundle properties = ResourceBundle.getBundle(args[0]);
        App app = new App();
        // app.printProperties(properties);
        // app.printSpecifyNumProperty(properties);
        try {
            app.outputCSV(properties);
        } catch (Exception e) {
            // NOP
        }
    }

    private void printProperties(ResourceBundle properties)
    {
        if (properties != null) 
        {
            Enumeration<String> keys = properties.getKeys();
            while (keys.hasMoreElements()) 
            {
                String key = keys.nextElement();
                String value = properties.getString(key);
                System.out.println(key + " : " + value);
            }
        }
    }

    private void printSpecifyNumProperty(ResourceBundle properties)
    {
        if (properties != null)
        {
            int hogeNum = Integer.parseInt(properties.getString("num"));
            for (int i = 0; i < hogeNum; i++)
            {
                String value = properties.getString("hoge" + (i + 1));
                System.out.println(value);
            }
        }

    }

    private void outputCSV(ResourceBundle properties) throws Exception
    {
        File outputDir = new File("/home/n-kyou/output");
        if (!outputDir.exists() && !outputDir.mkdir()) 
        {
            System.err.println("mkdir is failed");
            System.exit(-1);
        }

        CsvListWriter listWriter = null;
        try 
        {
            listWriter = new CsvListWriter(new FileWriter("/home/n-kyou/output/output.csv"), CsvPreference.STANDARD_PREFERENCE);

            if (properties != null) 
            {
                Enumeration<String> keys = properties.getKeys();
                while (keys.hasMoreElements()) 
                {
                    String key = keys.nextElement();
                    String value = properties.getString(key);
                    listWriter.write(key, value);
                }
            }
        } finally 
        {
            if( listWriter != null ) 
            {
                listWriter.close();
            }
        }
    }
}
