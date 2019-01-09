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
    
    /*public void ProfileQuestionRequest(ProfileUpdateRequest request, Callback<ProfileUpdateResponse> callback) {
        Call<ProfileUpdateResponse> call = null;
        try {
            ApiInterface apiService = ApiClient.getClient ().create (ApiInterface.class);
            Log.d (TAG, "ProfileUpdate Request URL : " + BASE_URL);
            call = apiService.profileUpdateRequest (request);
            call.enqueue (callback);
        } catch (Exception e) {
            Log.e (TAG, e.toString (), e);
            callback.onFailure (call, e);
        }
    }*/
    
    /*@Headers({"content-type: application/json"})
    @POST("/api/profile/checkout")
    Call<CheckOutResponse> checkOutRequestWithId(@Body CheckOutRequestWithId request);*/

}
