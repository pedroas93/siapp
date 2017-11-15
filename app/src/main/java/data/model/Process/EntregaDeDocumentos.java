package data.model.Process;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pedroas93 on 19/10/17.
 */

public class EntregaDeDocumentos {

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
            return "EntregaDeDocumentos{" +
                    ", status=" + status + '\'' +
                    '}';
        }

    }

