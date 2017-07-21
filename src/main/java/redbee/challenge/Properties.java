package redbee.challenge;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * Created by ftesei on 19/07/17.
 */
public class Properties {
    private final java.util.Properties configProp = new java.util.Properties();

    private Properties()
    {
        InputStream in = this.getClass().getResourceAsStream("/app.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static class PropertiesSingleton {
        private static final Properties INSTANCE = new Properties();
    }

    public static Properties getInstance()
    {
        return PropertiesSingleton.INSTANCE;
    }

    public String getProperty(String key){
        return configProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames(){
        return configProp.stringPropertyNames();
    }

    public boolean containsKey(String key){
        return configProp.containsKey(key);
    }
}
