package data.model.Process;

/**
 * Created by pedroas93 on 19/10/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SolicitudSelectividadDocTransporte {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private String status;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "SolicitudSelectividadDocTransporte{" +
                ", status=" + status + '\'' +
                ", type=" + type + '\'' +
                '}';
    }
}