package data.model.Process;

/**
 * Created by pedroas93 on 19/10/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnticipoAGirar {

    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AnticipoAGirar{" +
                ", status=" + status +
                '}';
    }


}