package com.example.majid.forurcomfy.Remote;

/**
 * Created by farha on 3/14/2018.
 */

public class ApiUtlis {
    public static final String BASE_URL = "https://node-practice0208.herokuapp.com";
    public static UserService getUserService (){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
    public static RegisterService getRegisterService(){
        return RetrofitClient.getClient(BASE_URL).create(RegisterService.class);
    }
}
