package com.example.pritam.michaeljackson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.pritam.michaeljackson.R;
import com.example.pritam.michaeljackson.model.Result;

public class DetailedInfoActivity extends AppCompatActivity {

    Result result;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_detailed_info);

        initilization();
        result = (Result) getIntent ().getExtras().getSerializable ("object");
        Log.d("TAG","Pritam :"+result.toString ());

        showInitilization();
    }

    private void showInitilization() {

        t1.setText (result.getArtistName ());
        t2.setText (result.getTrackName ());
        t3.setText (result.getCollectionName ());
        t4.setText (result.getTrackCensoredName ());
        t5.setText (result.getArtistId ().toString ());
        t6.setText (result.getArtistId ().toString ());
        t7.setText (result.getCollectionExplicitness ());
        t8.setText (result.getTrackPrice ().toString ());
        t9.setText (result.getIsStreamable ().toString ());
        t10.setText (result.getTrackTimeMillis ().toString ());
        t11.setText (result.getWrapperType ());
        t12.setText (result.getTrackViewUrl ());
        t13.setText (result.getReleaseDate ());
        t14.setText (result.getCountry ());
        t15.setText (result.getTrackNumber ().toString ());
        t16.setText (result.getPrimaryGenreName ());
        t17.setText (result.getCurrency ());
        t18.setText (result.getDiscCount ().toString ());
        t19.setText (result.getArtworkUrl60 ());
        t20.setText (result.getTrackNumber ().toString ());

    }

    private void initilization() {
        t1=(TextView)findViewById (R.id.t1);
        t2=(TextView)findViewById (R.id.t2);
        t3=(TextView)findViewById (R.id.t3);
        t4=(TextView)findViewById (R.id.t4);
        t5=(TextView)findViewById (R.id.t5);
        t6=(TextView)findViewById (R.id.t6);
        t7=(TextView)findViewById (R.id.t7);
        t8=(TextView)findViewById (R.id.t8);
        t9=(TextView)findViewById (R.id.t9);
        t10=(TextView)findViewById (R.id.t10);
        t11=(TextView)findViewById (R.id.t11);
        t12=(TextView)findViewById (R.id.t12);
        t13=(TextView)findViewById (R.id.t13);
        t14=(TextView)findViewById (R.id.t14);
        t15=(TextView)findViewById (R.id.t15);
        t16=(TextView)findViewById (R.id.t16);
        t17=(TextView)findViewById (R.id.t17);
        t18=(TextView)findViewById (R.id.t18);
        t19=(TextView)findViewById (R.id.t19);
        t20=(TextView)findViewById (R.id.t20);
    }
}
