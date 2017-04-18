package kyo.example;

import java.util.ResourceBundle;
import java.util.Enumeration;

public class App { 

    public static void main(String[] args) 
    {
        ResourceBundle properties = ResourceBundle.getBundle("example");
        App app = new App();
        app.printProperties(properties);
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
}
