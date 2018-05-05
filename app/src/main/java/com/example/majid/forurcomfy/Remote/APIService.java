package com.example.majid.forurcomfy.Remote;

import com.example.majid.forurcomfy.Data.model.FoodMenu;
import com.example.majid.forurcomfy.ShoppingCart.ShoppingItem;
import com.example.majid.forurcomfy.model.Post;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by farha on 4/2/2018.
 */
public interface APIService {

    @POST("/login")
    @FormUrlEncoded
    Call<Post> savePost(@Field("email") String email,
                        @Field("password") String pass);

    @GET("/food_menu")
    Call<List<FoodMenu>> reqData();

    @POST("/order")
    @FormUrlEncoded
    Call<Post> request(@Field("foodName") String foodName,
                        @Field("price") String price,
                        @Field("cell") String cell,
                        @Field("location") String address,
                        @Field("quantity") String quantity,
                        @Field("time") Date date);

    @GET("/delivery/request")
    Call<List<ShoppingItem>> reqDelivery();
}
