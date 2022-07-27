package modelo;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Coverphoto
{
    int id;
    int idBook;
    String url;



    public JSONObject getJson() throws JSONException {
        return new JSONObject(new Gson().toJson(this));
    }

    public String getXml()
    {
        return XML.toString(getJson());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
