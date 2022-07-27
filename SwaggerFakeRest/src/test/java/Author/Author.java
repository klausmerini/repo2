package Author;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Author
{
    Integer id;
    int idBook;
    String FirstName;
    String LastName;

    public Author(int idBook, String firstName, String lastName) {

        this.idBook = idBook;
        FirstName = firstName;
        LastName = lastName;
    }

    public JSONObject getJson() throws JSONException {
        return new JSONObject(new Gson().toJson(this));
    }

    public String getXml()
    {
        return XML.toString(getJson());
    }

}
