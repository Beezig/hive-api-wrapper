package pw.roccodev.beezig.hiveapi.wrapper.utils.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.Downloader;

import java.net.URL;

public class LazyArray extends JArray {

    private URL url;

    public LazyArray(JSONArray in, URL toResolve) {
        super(in);
        this.url = toResolve;
    }

    private void checkIfSourceExists() {
        if(jsonInput != null) return;
        jsonInput = new Downloader().getJsonArray(url).getInput();
    }

    @Override
    public String getString(int index) {
        checkIfSourceExists();
        return super.getString(index);
    }

    @Override
    public long getLong(int index) {
        checkIfSourceExists();
        return super.getLong(index);
    }

    @Override
    public JSONObject getJSONObject(int index) {
        checkIfSourceExists();
        return super.getJSONObject(index);
    }

    @Override
    public JObject getJObject(int index) {
        checkIfSourceExists();
        return super.getJObject(index);
    }

    @Override
    public JSONArray getJSONArray(int index) {
        checkIfSourceExists();
        return super.getJSONArray(index);
    }

    @Override
    public JArray getJArray(int index) {
        checkIfSourceExists();
        return super.getJArray(index);
    }

    @Override
    public int getInt(int index) {
        checkIfSourceExists();
        return super.getInt(index);
    }

    @Override
    public boolean getBoolean(int index) {
        checkIfSourceExists();
        return super.getBoolean(index);
    }

    @Override
    public double getDouble(int index) {
        checkIfSourceExists();
        return super.getDouble(index);
    }

    public void fetch() {
        checkIfSourceExists();
    }
}
