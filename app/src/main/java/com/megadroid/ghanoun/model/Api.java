package com.megadroid.ghanoun.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL="http://www.simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
