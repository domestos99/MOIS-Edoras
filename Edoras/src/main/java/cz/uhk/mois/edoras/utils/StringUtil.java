package cz.uhk.mois.edoras.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class StringUtil
{
    private static boolean isNull(String s)
    {
        return s == null;
    }

    public static boolean isEmptyOrNull(final String s)
    {
        return s == null || s.length() == 0;
    }

    public static String trim(final String s, final char ch)
    {
        if (isEmptyOrNull(s))
            return s;

        String result = s;

        char start = s.charAt(0);
        if (ch == start)
        {
            result = s.substring(1, s.length() - 1);
        }

        char end = result.charAt(result.length() - 1);


        if (ch == end)
        {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    public static String join(List<String> list, char c)
    {
        if (list == null || list.size() == 0)
            return null;

        String result = "";

        for (String s : list)
        {
            if (StringUtil.isEmptyOrNull(s))
                continue;

            result = result + s + c;
        }
        result = trim(result, c);
        return result;
    }

    public static List<String> split(String source, String delimiter)
    {
        List<String> results = new LinkedList<>();

        if (StringUtil.isEmptyOrNull(source))
        {
            return results;
        }

        String[] elements = source.split(delimiter);
        Collections.addAll(results, elements);

        return results;
    }

    public static String removeSpaces(final String str)
    {
        if (isEmptyOrNull(str))
            return str;
        return str.replaceAll("\\s+", "").replace(" ", "").trim();
    }

    public static byte[] toBytes(String s)
    {
        if (isNull(s))
            return null;
        if (isEmptyOrNull(s))
            return new byte[0];

        return s.getBytes();
    }

    public static String getString(byte[] bytes)
    {
        if (bytes == null)
            return null;

        return new String(bytes);
    }

    public static String toFirstUpper(final String str)
    {
        if (isEmptyOrNull(str))
            return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static boolean areEqual(String strA, String strB)
    {
        return Objects.equals(strA, strB);
    }

    public static String convertStreamToString(final InputStream in) throws IOException
    {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) != -1)
        {
            result.write(buffer, 0, length);
        }
        // StandardCharsets.UTF_8.name() > JDK 7
        return result.toString("UTF-8");
    }
}
