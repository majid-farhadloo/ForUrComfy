package com.example.majid.forurcomfy.Remote;

import com.example.majid.forurcomfy.model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by farha on 4/2/2018.
 */
public interface APIService{

    @POST("/login")
    @FormUrlEncoded
    Call<Post> savePost(@Field("email") String email,
                        @Field("password") String pass);
}
