package com.ipinyou.experiment;

import java.io.FileReader;
import java.util.Properties;
import java.util.Set;
import java.util.Iterator;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {

    public static void main(String args[]) throws Exception {
        System.out.println("test");
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/conf/application.conf"));
        System.out.println(properties.getProperty("spark.topic"));
        Set  set = properties.keySet();
        java.util.Iterator it = set.iterator();
        while (it.hasNext()) {
            System.err.println(it.next());
        }

        System.err.println(properties.getProperty("topic"));
        Config config = ConfigFactory.parseFile(new java.io.File("src/main/resources/conf/application.conf"));
        System.err.println("topic " + config.getString("spark.topic"));

    }
}
