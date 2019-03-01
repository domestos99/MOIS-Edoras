package cz.uhk.mois.edoras.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.uhk.mois.edoras.bankingapi.model.Payment;

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

    public static List<Payment> toList(Payment[] payments)
    {
        return Arrays.asList(payments);
    }
}
