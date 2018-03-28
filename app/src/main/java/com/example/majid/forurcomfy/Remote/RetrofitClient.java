package com.example.majid.forurcomfy.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by farha on 3/14/2018.
 */

public class RetrofitClient {
    public static Retrofit retrofit = null;
    public static Retrofit getClient (String url){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
