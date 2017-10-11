package com.example.parktaeim.dorothy;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import com.google.gson.JsonObject;

/**
 * Created by parktaeim on 2017. 10. 3..
 */


public interface RestAPI {
   @FormUrlEncoded
    @POST(APIUrl.SIGN_UP_URL)
    Call<Void> signUp(@Field("id") String id, @Field("password") String password, @Field("phone") String phone, @Field("name") String name);

    @FormUrlEncoded
    @POST(APIUrl.LOGIN_URL)
    Call<Void> login(@Field("id") String id, @Field("password") String password);

}