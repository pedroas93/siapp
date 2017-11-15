package data.model.Process;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


    public class Get {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("data")
        @Expose
        private data.model.Process.Data data;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public data.model.Process.Data getData() {
            return data;
        }

        public void setData(data.model.Process.Data data) {
            this.data = data;
        }

        @Override
    public String toString() {
        return "GetProcess{" +
                ", status=" + status + '\'' +
                ", data=" + data + '\'' +
                '}';
    }
}