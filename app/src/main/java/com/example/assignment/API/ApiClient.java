package com.example.assignment.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static  final String BASE_URL = "https://api.backendless.com/B0F489DA-0A9D-6BA6-FFAB-00E7402B1C00/36AD872E-D755-B64B-FFC2-E038FA1F0D00/data/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }

}
