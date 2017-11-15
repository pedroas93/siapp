package data.remote;

import android.util.Log;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://siapp4973.cloudapp.net:3000";

    public static APIService getAPIService() {
        Log.i("Totea","Aqui se totea");
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}