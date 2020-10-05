package com.example.SignStar.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("https://json.astrologyapi.com/v1/astro_details")
    Call<Example> getData(@Query("q") String name);


}
