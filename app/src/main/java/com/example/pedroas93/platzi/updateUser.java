package com.example.pedroas93.platzi;

/**
 * Created by pedroas93 on 30/11/17.
 */

public class updateUser {

    private String deviceId ;
    private String deviceType ;

    public updateUser(String deviceId, String deviceType) {

        this.deviceType = deviceType;
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
