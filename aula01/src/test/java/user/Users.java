package user;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Users {

    private String email;
    private String gender;
    private String name;

    private String status;

    public Users(String email, String gender, String name, String status) {
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.status = status;
    }

    public JSONObject getJson() throws JSONException {

        return new JSONObject(new Gson().toJson(this));
    }

    public String getXml()
    {
        return XML.toString(getJson());
    }

}
