package VWOLogin.com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    // Read the browser = Chrome -> give to Driver Manager

    public PropertyReader() //constructor created
    {

    }

    public static String readKey(String key) {
        FileInputStream fileInputStream=null;
        Properties p = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
            p=new Properties();
            p.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p.getProperty(key);
    }

}
