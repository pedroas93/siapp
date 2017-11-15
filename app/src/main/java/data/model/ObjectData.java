package data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectData {

    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ObjectDataModel{" +
                "token='" + token + '\'' +
                '}';
    }
}