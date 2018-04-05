package com.example.majid.forurcomfy.Remote;

import com.example.majid.forurcomfy.model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
/**
 * Created by farha on 4/2/2018.
 */
public interface RegisterService {

    @POST("/register")
    @FormUrlEncoded
    Call<Post> savePostRegister(@Field("fname") String firstName,
                        @Field("lname") String lastName,
                        @Field("mobilePhone") String mobileNumber,
                        @Field("email") String email,
                        @Field("password") String pass,
                        @Field("reTypePassword") String retypePass);
}


//public interface RegisterService {
//    @GET("Register/{firstName}/{LastName}/{cellPhone}/{email}/{password}/{reTypePassword}")
//    Call<ResObj> register(@Path("firstName") String firstName, @Path("LastName") String LastName
//            , @Path("cellPhone") String cellPhone, @Path("email") String email,
//                          @Path("password")String password, @Path("reTypePassword")
//                                  String reTypePassword);
//}
