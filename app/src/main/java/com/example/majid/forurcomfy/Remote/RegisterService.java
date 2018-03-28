package com.example.majid.forurcomfy.Remote;

import com.example.majid.forurcomfy.model.ResObj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by farha on 3/14/2018.
 */

public interface RegisterService {
    @GET("Register/{firstName}/{LastName}/{cellPhone}/{email}/{password}/{reTypePassword}")
    Call<ResObj> register(@Path("firstName") String firstName, @Path("LastName") String LastName
    , @Path("cellPhone") String cellPhone, @Path("email") String email,
                          @Path("password")String password, @Path("reTypePassword")
                                  String reTypePassword);
}

