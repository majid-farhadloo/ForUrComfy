package com.example.majid.forurcomfy.Remote;

import com.example.majid.forurcomfy.model.ResObj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by farha on 3/14/2018.
 */

public interface UserService {
    @GET("login/{email}/{password}")
    Call<ResObj> login(@Path("email") String email,@Path("password") String password);
}
