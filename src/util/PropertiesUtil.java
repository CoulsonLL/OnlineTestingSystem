package util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil
{


    private static Properties props;

    static
    {
        String fileName = "datasource.properties";
        props = new Properties();
        try
        {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
        }
        catch (IOException e)
        {
        }
    }


    public static String getProperty(String key)
    {
        String value = props.getProperty(key.trim());
        if (value == null)
        {
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key, String defaultValues)
    {

        String value = props.getProperty(key.trim());
        if (value == null)
        {
            value = defaultValues;
        }
        return value.trim();
    }

}
