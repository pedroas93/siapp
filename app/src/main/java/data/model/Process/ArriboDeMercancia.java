package data.model.Process;

/**
 * Created by pedroas93 on 19/10/17.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArriboDeMercancia {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("value")
    @Expose
    private String value;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ArriboDeMercancia{" +
                "Value='" + value + '\'' +
                "status='" + status + '\'' +
                '}';
    }

}