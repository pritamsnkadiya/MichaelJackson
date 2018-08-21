package com.example.pritam.michaeljackson.api;

import com.example.pritam.michaeljackson.model.MichaelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface ApiInterface {

    public static final int DEFAULT_PAGE_SIZE = 10;

    @Headers({"Accept: application/json"})
    @GET
    Call<MichaelResponse> getResul(@Url String url, @Header("Authorization") String tokenId);

}
