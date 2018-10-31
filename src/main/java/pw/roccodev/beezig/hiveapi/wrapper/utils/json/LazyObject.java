package pw.roccodev.beezig.hiveapi.wrapper.utils.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.Downloader;

import java.net.URL;

public class LazyObject extends JObject {

    private URL url;

    public LazyObject(JSONObject in, URL toResolve) {
        super(in);
        url = toResolve;
    }

    private void checkIfSourceExists() {
        if(jsonInput != null) return;
        jsonInput = new Downloader().getJsonObject(url).getInput();
    }

    @Override
    public String getString(String key) {
        checkIfSourceExists();
        return super.getString(key);
    }

    @Override
    public long getLong(String key) {
        checkIfSourceExists();
        return super.getLong(key);
    }

    @Override
    public JSONObject getJSONObject(String key) {
        checkIfSourceExists();
        return super.getJSONObject(key);
    }

    @Override
    public JObject getJObject(String key) {
        checkIfSourceExists();
        return super.getJObject(key);
    }

    @Override
    public JSONArray getJSONArray(String key) {
        checkIfSourceExists();
        return super.getJSONArray(key);
    }

    @Override
    public JArray getJArray(String key) {
        checkIfSourceExists();
        return super.getJArray(key);
    }

    @Override
    public int getInt(String key) {
        checkIfSourceExists();
        return super.getInt(key);
    }

    @Override
    public boolean getBoolean(String key) {
        checkIfSourceExists();
        return super.getBoolean(key);
    }

    @Override
    public double getDouble(String key) {
        checkIfSourceExists();
        return super.getDouble(key);
    }

    public void fetch() {
        checkIfSourceExists();
    }
}

