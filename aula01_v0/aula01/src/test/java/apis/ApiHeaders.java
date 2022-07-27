package apis;

import utils.APIUtils;
import utils.PropertiesUtils;

import java.util.Map;

public class ApiHeaders extends APIUtils {

    PropertiesUtils propertiesUtils = new PropertiesUtils();

    public Map<String, String> gorestHeaders(String token) {
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", token);

        return headers;
    }

    public Map<String, String> fakerestHeaders(String token) {
        headers.put("Accept", "text/plain");

        return headers;
    }
}
