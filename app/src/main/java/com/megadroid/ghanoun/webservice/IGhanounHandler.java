package com.megadroid.ghanoun.webservice;

import android.app.Application;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface IGhanounHandler {

    @FormUrlEncoded
    @GET("getBestApplications.php")
    public Call<List<Application>> getBestApps();

    @FormUrlEncoded
    @GET("getNewApplications.php")
    public Call<List<Application>> getNewApps();

    @FormUrlEncoded
    @GET("getAnnouncements.php")
    public Call<List<Application>> getAnnouncements();

    @FormUrlEncoded
    @POST("getCategory.php")
    public Call<List<Locale.Category>> getCategories(@Field("from") int from ,@Field("to") int to);
}
