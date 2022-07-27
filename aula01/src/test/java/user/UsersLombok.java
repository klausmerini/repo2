package user;

import io.cucumber.messages.internal.com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

@Data
@Builder
@Getter
@Setter
public class UsersLombok
{
    private String email;
    private String gender;
    private String name;
    private String status;


    public JSONObject getJson() throws JSONException
    {
        return new JSONObject(new Gson().toJson(this));
    }

    public String getXml()
    {
        return XML.toString(getJson());
    }

}
