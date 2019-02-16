package cz.uhk.mois.edoras.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetTask
{
    public static String GetDataFromUrl(final String url)
    {
        HttpURLConnection c = null;
        try
        {
            final URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);

            int timeout = 5000;

            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);

            c.connect();
            final int status = c.getResponseCode();

            switch (status)
            {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    br.close();
                    return sb.toString();
                default:
                    throw new Exception("Invalid status code: " + status);
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (c != null)
            {
                try
                {
                    c.disconnect();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
}