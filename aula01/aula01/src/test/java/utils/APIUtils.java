package utils;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class APIUtils extends LogUtils {
    protected static Response response;
    protected static String uri;
    protected static Map<String, String> headers = new HashMap<>();
    protected static Map<String, String> params = new HashMap<>();
    protected static String token;
    protected static JSONObject body;

    public void log(String verbo) {
        super.logInfo("******* Ddos enviados no request *******");
        super.logInfo(verbo + " " + uri);
        super.logInfo(" Body : \n" + body);
        super.logInfo(" Headers : \n" + headers);
        super.logInfo("  Params : \n" + params);

        super.logInfo(" ******* dados recebidos *******");
        super.logInfo(" status code 	" + response.statusCode());
        super.logInfo(" payload recebido " + response.asPrettyString());
        super.logInfo(" tempo de respodta " + response.timeIn(TimeUnit.MILLISECONDS));

    }
}
