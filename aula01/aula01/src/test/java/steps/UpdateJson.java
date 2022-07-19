package steps;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import utils.JsonUtils;

import java.io.IOException;

public class UpdateJson {
    JsonUtils jsonUtils = new JsonUtils();

    @Test
    public void updateJson() throws JSONException, IOException {
        JSONObject js = jsonUtils.parseJsonFile("json_update");
        System.out.println(jsonUtils.updateJson(js, "email", "mermes@yahoo.com"));
    }
}
