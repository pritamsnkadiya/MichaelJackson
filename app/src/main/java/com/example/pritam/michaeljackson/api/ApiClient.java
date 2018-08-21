package com.example.pritam.michaeljackson.api;

import android.content.Context;
import android.util.Log;

import com.example.pritam.michaeljackson.model.MichaelResponse;
import com.example.pritam.michaeljackson.utils.Constant;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient implements Serializable {

    private static final String TAG = ApiClient.class.getSimpleName ();

    private static final boolean production = false;//BuildConfig.DEBUG;


    public static final String BASE_URL = production ? "http://ipl-api-access-layer.eu-gb.mybluemix.net/api/v1/" : "http://ipl-api-access-layer.eu-gb.mybluemix.net/api/v1/";


    public static boolean isProduction() {
        return production;
    }

    private static Retrofit retrofit = null;

    private static ApiClient apiClient;

    private Context context;

    private static final Object mLock = new Object ();

    public ApiClient() {
    }

    public ApiClient(Context context) {
        this.context = context;
    }

    public static ApiClient getSingletonApiClient() {
        synchronized (mLock) {
            if (apiClient == null)
                apiClient = new ApiClient ();

            return apiClient;
        }
    }

    private static Retrofit getClient() {
        if (retrofit == null) {
            //OkHttpClient.Builder client = new OkHttpClient.Builder();

            OkHttpClient.Builder okHttpClient = new OkHttpClient ().newBuilder ()
                    .connectTimeout (60 * 5, TimeUnit.SECONDS)
                    .readTimeout (60 * 5, TimeUnit.SECONDS)
                    .writeTimeout (60 * 5, TimeUnit.SECONDS);

            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create ();
            retrofit = new Retrofit.Builder ()
                    .baseUrl (BASE_URL)
                    .client (okHttpClient.build ())
                    .addConverterFactory (gsonConverterFactory)
                    .build ();

        }
        return retrofit;
    }

    public void profileDetailCall(String token, Callback<MichaelResponse> callback) {
        Call<MichaelResponse> call = null;
        try {
            ApiInterface apiService = ApiClient.getClient ().create (ApiInterface.class);
            Log.d (TAG, "MichaelResponse Detail Request URL : " + Constant.API_RESPONSE_DETAIL);
            //Log.d(TAG, "OrderDetail Request URL : "+BASE_URL + Constant.API_ORDERS+id);
            call = apiService.getResul (Constant.API_RESPONSE_DETAIL, token);
            call.enqueue (callback);
        } catch (Exception e) {
            Log.e (TAG, e.toString (), e);
            callback.onFailure (call, e);
        }
    }

}