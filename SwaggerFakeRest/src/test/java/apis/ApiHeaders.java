package apis;

import utils.APIUtils;
import utils.PropertiesUtils;

import java.util.Map;

public class ApiHeaders extends APIUtils {

    PropertiesUtils propertiesUtils = new PropertiesUtils();

    public Map<String, String> fakerestHeaders(String token) {
        headers.put("Accept", "text/plain");
        headers.put("Content-Type", "application/json");

        return headers;
    }
}
