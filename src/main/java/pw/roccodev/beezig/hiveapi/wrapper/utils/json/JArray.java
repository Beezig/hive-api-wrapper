package pw.roccodev.beezig.hiveapi.wrapper.utils.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JArray {

    JSONArray jsonInput;

    public JArray(JSONArray in) {
        this.jsonInput = in;
    }

    public String getString(int index) {
        return (String) jsonInput.get(index);
    }

    public long getLong(int index) {
        return (long) jsonInput.get(index);
    }

    public JSONObject getJSONObject(int index) {
        return (JSONObject) jsonInput.get(index);
    }

    public JObject getJObject(int index) {
        return new JObject(getJSONObject(index));
    }

    public JSONArray getJSONArray(int index) {
        return (JSONArray) jsonInput.get(index);
    }

    public JArray getJArray(int index) {
        return new JArray(getJSONArray(index));
    }

    public int getInt(int index) {
        return (int) getLong(index);
    }

    public boolean getBoolean(int index) {
        return (boolean) jsonInput.get(index);
    }

    public double getDouble(int index) {
        return (double) jsonInput.get(index);
    }

    public JSONArray getInput() {
        return jsonInput;
    }
    
}
