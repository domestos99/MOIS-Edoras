package cz.uhk.mois.edoras.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import cz.uhk.mois.edoras.logger.LoggerFacade;

public class JsonUtilsSafe
{
    public static String getPretty(final String json)
    {
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement el = parser.parse(json);
        return gson.toJson(el); // done
    }

    public static <T> T fromJson(String serialized, Class<T> clazz)
    {
        try
        {
            if (StringUtil.isEmptyOrNull(serialized))
                return null;

            return JsonUtils.fromJson(serialized, clazz);
        }
        catch (Exception e)
        {
            LoggerFacade.log(e);
            return null;
        }
    }

    public static String toJson(Object object)
    {
        try
        {
            return JsonUtils.toJson(object);
        }
        catch (Exception e)
        {
            LoggerFacade.log(e);
            return null;
        }
    }

}
