package pw.roccodev.beezig.hiveapi.wrapper.utils.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JObject {

    JSONObject jsonInput;

    public JObject(JSONObject in) {
        this.jsonInput = in;
    }

    public String getString(String key) {
        return (String) jsonInput.get(key);
    }

    public long getLong(String key) {
        return (long) jsonInput.get(key);
    }

    public JSONObject getJSONObject(String key) {
        return (JSONObject) jsonInput.get(key);
    }

    public JObject getJObject(String key) {
        return new JObject(getJSONObject(key));
    }

    public JSONArray getJSONArray(String key) {
        return (JSONArray) jsonInput.get(key);
    }

    public JArray getJArray(String key) {
        return new JArray(getJSONArray(key));
    }

    public int getInt(String key) {
        return (int) getLong(key);
    }

    public boolean getBoolean(String key) {
        return (boolean) jsonInput.get(key);
    }

    public double getDouble(String key) {
        return (double) jsonInput.get(key);
    }

    public JSONObject getInput() {
        return jsonInput;
    }

}
