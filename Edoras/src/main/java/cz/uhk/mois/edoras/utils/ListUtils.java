package cz.uhk.mois.edoras.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils
{
    public static <T> List<T> toList(final Iterable<T> iter)
    {
        final List<T> result = new ArrayList<>();

        if (iter == null)
            return result;
        for (T ent : iter)
            result.add(ent);
        return result;
    }

    public static <T> List<T> toList(T[] data)
    {
        return Arrays.asList(data);
    }

    public static <T> Iterable<T> toIterable(T[] data)
    {
        return Arrays.asList(data);
    }
}
