package cz.uhk.mois.edoras.utils;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


public class JsonUtilsSafeTest
{

    @Test
    public void formatPrettyTest()
    {
        final String json = "{\"name\":\"John Deo\"}";
        String pretty = JsonUtilsSafe.getPretty(json);
        assertNotNull(pretty);
    }

    @Test
    public void serializeTest()
    {
        Temp temp = new Temp();
        temp.a = 1;
        temp.b = "B";
        temp.c = true;
        temp.d = new int[]{1, 2, 3, 4, 5};
        temp.e = new ArrayList<>();
        temp.e.add("one");
        temp.e.add("two");
        temp.e.add("three");
        temp.types = Types.TYPE2;

        String json = JsonUtilsSafe.toJson(temp);

        System.out.println(json);

        assertNotNull(json);


        Temp tmp = JsonUtilsSafe.fromJson(json, Temp.class);


        assertEquals(temp.a, tmp.a);
        assertEquals(temp.b, tmp.b);
        assertEquals(temp.c, tmp.c);
        assertArrayEquals(temp.d, tmp.d);
        assertEquals(temp.d.length, tmp.d.length);
        assertEquals(temp.e.size(), tmp.e.size());
        assertEquals(Types.TYPE2, temp.types);

    }

    @Test
    public void serializeBase()
    {

        B b = new B();
        b.setParA("paramA");
        b.setParB("paramB");

        String json = serializeMe(b);


        A aa = JsonUtilsSafe.fromJson(json, A.class);
        assertNotNull(aa);
        assertEquals("paramA", aa.getParA());

        B bb = JsonUtilsSafe.fromJson(json, B.class);
        assertNotNull(bb);
        assertEquals("paramA", bb.getParA());
        assertEquals("paramB", bb.getParB());

    }


    @Test
    public void serializeStringTest()
    {
        String s1 = "abcáéí";

        String json = JsonUtilsSafe.toJson(s1);

        assertNotEquals(s1, json);

        assertEquals("\"abcáéí\"", json);
    }

    private String serializeMe(A a)
    {
        return JsonUtilsSafe.toJson(a);
    }

    enum Types
    {
        TYPE1,
        TYPE2,
        TYPE3
    }

    class Temp
    {
        int a;
        String b;
        boolean c;
        int[] d;
        ArrayList<String> e;

        Types types;

        public int getA()
        {
            return a;
        }

        public void setA(int a)
        {
            this.a = a;
        }

        public String getB()
        {
            return b;
        }

        public void setB(String b)
        {
            this.b = b;
        }

        public boolean isC()
        {
            return c;
        }

        public void setC(boolean c)
        {
            this.c = c;
        }

        public int[] getD()
        {
            return d;
        }

        public void setD(int[] d)
        {
            this.d = d;
        }

        public ArrayList<String> getE()
        {
            return e;
        }

        public void setE(ArrayList<String> e)
        {
            this.e = e;
        }

        public Types getTypes()
        {
            return types;
        }

        public void setTypes(Types types)
        {
            this.types = types;
        }
    }

    class A
    {
        private String parA;

        public String getParA()
        {
            return parA;
        }

        public void setParA(String parA)
        {
            this.parA = parA;
        }
    }

    class B extends A
    {
        private String parB;

        public String getParB()
        {
            return parB;
        }

        public void setParB(String parB)
        {
            this.parB = parB;
        }
    }


}