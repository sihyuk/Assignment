package com.example.assignment.API;

import com.example.assignment.Model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("contacts_info")
    Call<List<Contact>> getContacts();


}
