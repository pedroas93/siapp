package data.model.Process;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pedroas93 on 30/10/17.
 */

public class ElaboracionDocExportacion {

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
        return "ElaboracionDeDocumentoDeExportacion{" +
                ", status=" + status + '\'' +
                '}';
    }


}
