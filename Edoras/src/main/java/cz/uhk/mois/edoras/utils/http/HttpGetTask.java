package cz.uhk.mois.edoras.utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import cz.uhk.mois.edoras.config.AppConfig;

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
            c.setUseCaches(true);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(AppConfig.ApiConnectTimeout);
            c.setReadTimeout(AppConfig.ApiConnectTimeout);

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
                    return null;
            }
        }
        catch (ProtocolException e)
        {
            e.printStackTrace();
            return null;
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
            return null;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
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
    }
}
