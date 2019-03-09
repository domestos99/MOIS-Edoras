package cz.uhk.mois.edoras.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;

public class JsonUtils
{
    private static final Gson objectMapper = new Gson();

    public static <T> T fromJson(byte[] serialized, Class<T> clazz)
    {
        return fromJson(new String(serialized), clazz);
    }

    public static <T> T fromJson(String serialized, Class<T> clazz)
    {
        return objectMapper.fromJson(serialized, clazz);
    }

    public static <T> T fromJson(Reader serialized, Class<T> clazz) throws IOException
    {
        return objectMapper.fromJson(serialized, clazz);
    }

    public static String toJson(Object object) throws IOException
    {
        return objectMapper.toJson(object);
    }
}
