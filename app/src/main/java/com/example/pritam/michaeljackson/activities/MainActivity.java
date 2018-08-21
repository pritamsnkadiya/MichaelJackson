package com.example.pritam.michaeljackson.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.pritam.michaeljackson.model.CustomRecyclerAdapter;
import com.example.pritam.michaeljackson.R;
import com.example.pritam.michaeljackson.api.ApiClient;
import com.example.pritam.michaeljackson.model.MichaelResponse;
import com.example.pritam.michaeljackson.utils.Constant;
import com.example.pritam.michaeljackson.utils.Methods;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName ();
    String accessToken = "";
    MichaelResponse michaelResponse;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<MichaelResponse> michaelResponseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById (R.id.recyclerView);
        recyclerView.setHasFixedSize (true);
        layoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager (layoutManager);
        michaelResponseList = new ArrayList<> ();

        callApiGetProfileData (accessToken);
    }

    private void callApiGetProfileData(String token) {
        try {
            ApiClient.getSingletonApiClient ().profileDetailCall (token, new Callback<MichaelResponse> () {
                @Override
                public void onResponse(Call<MichaelResponse> call, Response<MichaelResponse> response) {

                    Log.d (TAG, "DriverDetail Data : " + response.body ());
                    michaelResponse = response.body ();
                    if (michaelResponse != null) {
                        // Store here
                        Log.d ("MichelResponse ", michaelResponse.toString () + "");
                        mAdapter = new CustomRecyclerAdapter (MainActivity.this, michaelResponse.getResults ());
                        recyclerView.setAdapter (mAdapter);

                    } else {
                        Methods.showPromptMessage (Constant.API_DETAIL);
                        finish ();
                    }
                }
                @Override
                public void onFailure(Call<MichaelResponse> call, Throwable t) {
                    Log.d (TAG, "Fetching Data Error : " + t.getMessage ());
                }
            });
        } catch (Exception e) {
            Log.d (TAG, "Error msg : " + e.getMessage ());
        }
    }
}
