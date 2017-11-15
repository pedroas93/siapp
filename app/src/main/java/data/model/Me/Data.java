package data.model.Me;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
        return "DataMe{" +
                "message='" + message + '\'' +
                ", objectData=" + objectData +
                '}';
    }

}

/*




 */