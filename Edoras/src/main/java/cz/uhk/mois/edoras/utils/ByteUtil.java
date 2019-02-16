package cz.uhk.mois.edoras.utils;

public class ByteUtil
{
    public static boolean isEmptyOrNull(byte[] bytes)
    {
        return (bytes == null || bytes.length == 0);
    }
}
