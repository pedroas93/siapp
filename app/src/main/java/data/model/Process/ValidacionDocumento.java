package data.model.Process;

/**
 * Created by pedroas93 on 19/10/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ValidacionDocumento {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("file")
    @Expose
    private String file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    @Override
    public String toString() {
        return "ValidacionDocumentos{" +
                ", name=" + name + '\'' +
                ", status=" + status + '\'' +
                ", file=" + file + '\'' +
                '}';
    }
}