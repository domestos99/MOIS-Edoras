package cz.uhk.mois.edoras.utils;

import java.util.ArrayList;

public class ListUtils
{
    public static <T> ArrayList<T> toList(final Iterable<T> iter)
    {
        final ArrayList<T> result = new ArrayList<>();

        if (iter == null)
            return result;
        for (T ent : iter)
            result.add(ent);
        return result;
    }
}
