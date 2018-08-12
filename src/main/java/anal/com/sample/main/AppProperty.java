package anal.com.sample.main;


import java.io.*;
import java.util.Properties;


public class AppProperty {

    public void loadParamsApplication() {
        try (InputStream in = new FileInputStream("src/main/resources/application.properties")) {
            Properties prop = new Properties();
            prop.load(in);
            System.out.println("####Properties.getProperty usage####");
            System.out.println(prop.getProperty("spring.datasource.url"));
            System.out.println();

            System.out.println("####Properties.stringPropertyNames usage####");
            for (String property : prop.stringPropertyNames()) {
                String value = prop.getProperty(property);
                System.out.println(property + "=" + value);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println();
    }
}
