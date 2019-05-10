package com.anjaneya2bgmail.kinematics;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class solDisplay extends AppCompatActivity {

    TextView r2;
    TextView filler;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        String acceleration = getIntent().getExtras().getString("acceleration");
        String time = getIntent().getExtras().getString("time");
        String distance = getIntent().getExtras().getString("distance");
        String ivelocity = getIntent().getExtras().getString("ivelocity");
        String fvelocity = getIntent().getExtras().getString("fvelocity");

        Double a = getIntent().getExtras().getDouble("a");
        Double t = getIntent().getExtras().getDouble("t");
        Double d = getIntent().getExtras().getDouble("d");
        Double Vi = getIntent().getExtras().getDouble("iv");
        Double Vf = getIntent().getExtras().getDouble("fv");

        r2 = (TextView)findViewById(R.id.result);
        filler = (TextView)findViewById(R.id.filler);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        r2.setText(Html.fromHtml("<b>" + "INPUTS: " + "</b>"));
        r2.append('\n'+ ""+'\n'+ "acceleration, a = " + acceleration+
                '\n'+ "final velocity, Vf = " + fvelocity+'\n'+ "displacement, d = " + distance+
                '\n'+ "initial velocity, Vi = " +ivelocity+ '\n'+ "time, t = " + time);
        r2.append('\n' + "" + '\n');
        r2.append(Html.fromHtml("<b>" + "RESULTS: " + "</b>"));
        r2.append('\n'+""+'\n');
        if (acceleration.equals("")){
            r2.append(Html.fromHtml("a = " + "<font color=green>" + fmt(a) +"</font>"));
            r2.append(""+ '\n');
        } else{
            r2.append("a = "+fmt(a));
            r2.append(""+ '\n');
        }if (fvelocity.equals("")){
            r2.append(Html.fromHtml("Vf = " + "<font color=green>" + fmt(Vf) +"</font>"));
            r2.append(""+ '\n');
        } else{
            r2.append("Vf = "+fmt(Vf));
            r2.append(""+ '\n');
        }if (distance.equals("")){
            r2.append(Html.fromHtml("d = " + "<font color=green>" + fmt(d) +"</font>"));
            r2.append(""+ '\n');
        } else{
            r2.append("d = "+fmt(d));
            r2.append(""+ '\n');
        }if (ivelocity.equals("")){
            r2.append(Html.fromHtml("Vi = " + "<font color=green>" + fmt(Vi) +"</font>"));
            r2.append(""+ '\n');
        } else{
            r2.append("Vi = "+fmt(Vi));
            r2.append(""+ '\n');
        }if (time.equals("")){
            r2.append(Html.fromHtml("t = " + "<font color=green>" + fmt(t) +"</font>"));
            r2.append(""+ '\n');
        } else{
            r2.append("t = "+fmt(t));
            r2.append(""+ '\n');
        }
        r2.append("\n"+"");
        filler.setText("\n\n\n\n");


    }
    public static String fmt(double d)
    {
        if(d == (int) d)
            return String.format("%d",(int)d);
        else
            return String.format("%s",d);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                mAdView.destroy();
                mAdView.setVisibility(View.GONE);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
