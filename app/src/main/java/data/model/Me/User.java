package data.model.Me;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("deviceType")
    @Expose
    private String deviceType;
    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("idCard")
    @Expose
    private String idCard;
    @SerializedName("created")
    @Expose
    private Boolean created;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("processes")
    @Expose
    private List<Object> processes = null;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Boolean getCreated() {
        return created;
    }

    public void setCreated(Boolean created) {
        this.created = created;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public List<Object> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Object> processes) {
        this.processes = processes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "UserMe{" +
                "status='" + status + '\'' +
                ", updatedAt=" + updatedAt +
                ", phone=" + phone +
                ", devicesID=" + deviceId +
                ", devices=Type" + deviceType +
                ", Type=" + type +
                ", address=" + address +
                ", id=" + id +
                ", created=" + created +
                ", idCard=" + idCard +
                ", Role=" + role +
                ", processes=" + processes +
                ", email=" + email +
                ", name=" + name +
                ", createdAt=" + createdAt +
                ", v=" + v +
                '}';

    }



}
