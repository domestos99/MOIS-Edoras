//package cz.uhk.mois.edoras;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.net.URL;
//import java.nio.charset.Charset;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import cz.uhk.mois.edoras.utils.StringUtil;
//import sun.net.www.protocol.http.HttpURLConnection;
//
//public class JsonReader
//{
//
//    private static String readAll(Reader rd) throws IOException
//    {
//        StringBuilder sb = new StringBuilder();
//        int cp;
//        while ((cp = rd.read()) != -1)
//        {
//            sb.append((char) cp);
//        }
//        return sb.toString();
//    }
//
//    public static JSONArray readJsonFromUrl(String surl) throws IOException, JSONException
//    {
//        if (StringUtil.isEmptyOrNull(surl))
//        {
//            throw new RuntimeException("surl cannot be null or empty");
//        }
//
//        URL url = new URL(surl);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.connect();
//        int responsecode = conn.getResponseCode();
//
//        if (responsecode != 200)
//            throw new RuntimeException("HttpResponseCode: " + responsecode);
//        else
//        {
//            InputStream is = conn.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//            String jsonText = readAll(rd);
//            JSONArray json = new JSONArray(jsonText);
//            return json;
//        }
//    }
//}