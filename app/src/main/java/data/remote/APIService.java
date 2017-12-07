package data.remote;

import com.example.pedroas93.platzi.updateUser;

import data.model.Me.Get;
import data.model.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface APIService {



    public static Object object3 = null;
    public static Object object2 = null;

    @POST("/api/v1/users/login")
    @FormUrlEncoded
    Call<Post> login(@Field("username") String username,
                     @Field("password") String password,
                     @Field("gethash") Boolean getHash

    );


    @GET("/api/v1/processes")
    Call<data.model.Process.Get> processes(@Header("Authorization") String token);

    @GET("/api/v1/users/me/")
    Call<Get> me(@Header("Authorization") String token);

    @PUT("/api/v1/users")
    @FormUrlEncoded
    Call<PUT> updateUser(@Header("Authorization") String token
                        ,@Field("name") String name
                        ,@Field("phone") String numero
                        ,@Field("address") String direccion
                        ,@Field("new_password") String contraseña
                        ,@Field("created") Boolean getHash);


    @PUT("/api/v1/users")
    Call<PUT> updateUser(@Header("Authorization") String token
            , @Body updateUser updateUser);


}