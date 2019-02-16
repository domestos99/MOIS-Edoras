package cz.uhk.mois.edoras.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class StringUtilTest
{


    @Test
    public void getStringTest()
    {
        byte[] bytes = null;

        String s = StringUtil.getString(bytes);

        assertNull(s);

        bytes = new byte[0];

        s = StringUtil.getString(bytes);

        assertEquals("", s);
    }

    @Test
    public void bytesStringConvert()
    {
        final String s = "hello world";

        final byte[] bytes = StringUtil.toBytes(s);

        assertNotNull(bytes);

        final String a = StringUtil.getString(bytes);

        assertEquals(s, a);


        final byte[] bytes2 = StringUtil.toBytes(null);

        assertNull(bytes2);
    }


    @Test
    public void Test1()
    {
        String s1 = "hello";

        String s2 = StringUtil.trim(s1, ',');

        assertNotNull(s2);
        assertEquals(s1, s2);
    }

    @Test
    public void Test2()
    {
        String s1 = "hello";

        String s2 = StringUtil.trim(s1, ' ');

        assertNotNull(s2);
        assertEquals(s1, s2);
    }

    @Test
    public void Test3()
    {
        String s1 = "hello,";

        String s2 = StringUtil.trim(s1, ',');

        assertNotNull(s2);
        assertEquals("hello", s2);
    }

    @Test
    public void Test4()
    {
        String s1 = "hello)";

        String s2 = StringUtil.trim(s1, ',');

        assertNotNull(s2);
        assertEquals("hello)", s2);
    }


    @Test
    public void Test5()
    {
        String s1 = null;

        String s2 = StringUtil.trim(s1, ',');

        // assertNotNull(s2);
        assertEquals(s1, s2);
    }

    @Test
    public void Test6()
    {
        String s1 = "";

        String s2 = StringUtil.trim(s1, ',');

        // assertNotNull(s2);
        assertEquals(s1, s2);
    }


    @Test
    public void Test7()
    {
        String s1 = "x";

        String s2 = StringUtil.trim(s1, ',');

        // assertNotNull(s2);
        assertEquals(s1, s2);
    }

    @Test
    public void Test8()
    {
        String s1 = "xxx";

        String s2 = StringUtil.trim(s1, ',');

        // assertNotNull(s2);
        assertEquals(s1, s2);
    }


    @Test
    public void Test9()
    {
        String s1 = "xxx,,";

        String s2 = StringUtil.trim(s1, ',');

        // assertNotNull(s2);
        assertEquals("xxx,", s2);
    }


    @Test
    public void Test10()
    {
        List<String> s = new ArrayList<>();

        s.add("a");
        s.add("bb");
        s.add("");
        s.add("cc");
        s.add(null);
        s.add("ddddddd");
        s.add("eeeeeee");

        String scv = StringUtil.join(s, ';');


        assertEquals("a;bb;cc;ddddddd;eeeeeee", scv);


    }

}