package utils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class JsonUtils {
    public JSONObject parseJsonFile() throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/json/create_user.json")));
        return new JSONObject(content);
    }

    public JSONObject parseJsonFile(String st) throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/json/" + st + ".json")));
        return new JSONObject(content);
    }

    public JSONObject updateJson(JSONObject obj, String keyMain, String newValue) throws JSONException {
        Iterator iterator = obj.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            if ((obj.optJSONArray(key) == null) && (obj.optJSONObject(key) == null)) {
                if (key.equals(keyMain)) {
                    obj.put(key, newValue);
                    return obj;
                }
            }
            if (obj.optJSONObject(key) != null) {
                updateJson(obj.getJSONObject(key), keyMain, newValue);
            }
            if (obj.optJSONObject(key) != null) {
                JSONArray jarray = obj.getJSONArray(key);
                for (int i = 0; i < jarray.length(); i++) {
                    updateJson(jarray.getJSONObject(i), keyMain, newValue);
                }
            }

        }
        return obj;
    }
}
