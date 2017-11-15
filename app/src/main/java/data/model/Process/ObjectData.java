package data.model.Process;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pedroas93 on 22/10/17.
 */



public class ObjectData {

    @SerializedName("process")
    @Expose
    private List<Process> process = null;

    public List<Process> getProcess() {
        return process;
    }

    public void setProcess(List<Process> process) {
        this.process = process;
    }
   @Override
    public String toString() {
        return "ObjectDataProccess{" +
                "process='" + process + '\'' +
                '}';
    }
}
