package com.playwright.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileReader {
    public static Map<String, String> loadProperties(String fileName){
        Map<String, String> propMap = new HashMap<>();

        try{
            ClassLoader classLoader = FileReader.class.getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            FileInputStream fin = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fin);
            System.out.println("loaded properties successfully:"+properties);

            Enumeration<?> keys = properties.propertyNames();
            while (keys.hasMoreElements()){
                String key = String.valueOf(keys.nextElement());
                propMap.put(key, properties.getProperty(key));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return propMap;
    }
}
