package pw.roccodev.beezig.hiveapi.wrapper.utils.download;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pw.roccodev.beezig.hiveapi.wrapper.GlobalConfiguration;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JArray;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class Downloader {


    public JObject getJsonObject(String url) throws MalformedURLException {
        return getJsonObject(new URL(url));
    }

    public JArray getJsonArray(String url) throws MalformedURLException {
        return getJsonArray(new URL(url));
    }

    public JObject getJsonObject(URL url) {
        return new JObject((JSONObject) readUrl(url));
    }

    public JArray getJsonArray(URL url) {
        return new JArray((JSONArray) readUrl(url));
    }


    private Object readUrl(URL url) {
        BufferedReader reader = null;
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.addRequestProperty("User-Agent", GlobalConfiguration.USER_AGENT);
            conn.setRequestProperty("Accept", "application/json");

            reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));


            JSONParser parser = new JSONParser();

            return parser.parse(reader);


        } catch (Exception ignored) {}
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }

            if(conn != null)
                conn.disconnect();
        }
        return null;
    }

}
