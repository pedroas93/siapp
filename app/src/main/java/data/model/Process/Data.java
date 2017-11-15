package data.model.Process;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pedroas93 on 22/10/17.
 */

public class Data {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("objectData")
    @Expose
    private ObjectData objectData;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ObjectData getObjectData() {
        return objectData;
    }

    public void setObjectData(ObjectData objectData) {
        this.objectData = objectData;
    }
    @Override
    public String toString() {
        return "DataProcess{" +
                "message='" + message + '\'' +
                ", objectData=" + objectData +
                '}';
    }
}
