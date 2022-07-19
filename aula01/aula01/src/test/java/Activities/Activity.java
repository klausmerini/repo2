package Activities;

import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Activity
{
    int id;
    String title;
    String dueDate;
    Boolean completed;


    public JSONObject getJson() throws JSONException {
        return new JSONObject(new Gson().toJson(this));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
