package ca.pragra.wd2.framwork.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

public class FrameworkConfig {
    private String fileName = "framework.properties";
    private static Properties properties;


    private FrameworkConfig(){
        try {
          InputStream inputStream = new FileInputStream("src/main/resources/"+fileName);
          properties = new Properties();
          properties.load(inputStream);
        }catch (IOException ex){
          ex.printStackTrace();
        }
    }

    public static String getProperty(String key){
        if(properties==null){
            new FrameworkConfig();
        }
//        if(properties.getProperty(key)==null){
//
//        }
        return properties.getProperty(key);
    }
}
