package com.anjaneya2bgmail.kinematics;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;

public class Main2Activity extends AppCompatActivity {

    static TextView r2;
    TextView filler;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        r2 = (TextView)findViewById(R.id.result);
        filler = (TextView)findViewById(R.id.filler);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        r2.setText(Html.fromHtml("<b>" + "INPUTS: " + "</b>"));
        r2.append('\n'+ ""+'\n'+ "acceleration, a = " + MainActivity.acceleration.getText()+
                '\n'+ "final velocity, Vf = " + MainActivity.fvelocity.getText()+'\n'+ "displacement, d = " + MainActivity.distance.getText()+
                '\n'+ "initial velocity, Vi = " + MainActivity.ivelocity.getText()+ '\n'+ "time, t = " + MainActivity.time.getText());
        r2.append('\n' + "" + '\n');
        r2.append(Html.fromHtml("<b>" + "RESULTS: " + "</b>"));
        r2.append('\n'+""+'\n');
        if (MainActivity.acceleration.getText().toString().equals("")){
            r2.append(Html.fromHtml("a = " + "<font color=green>" + fmt(MainActivity.a) +"</font>"));
            r2.append(""+ '\n');
        }
        else{
            r2.append("a = "+fmt(MainActivity.a));
            r2.append(""+ '\n');
        }
        if (MainActivity.fvelocity.getText().toString().equals("")){
            r2.append(Html.fromHtml("Vf = " + "<font color=green>" + fmt(MainActivity.Vf) +"</font>"));
            r2.append(""+ '\n');
        }
        else{
            r2.append("Vf = "+fmt(MainActivity.Vf));
            r2.append(""+ '\n');
        }
        if (MainActivity.distance.getText().toString().equals("")){
            r2.append(Html.fromHtml("d = " + "<font color=green>" + fmt(MainActivity.d) +"</font>"));
            r2.append(""+ '\n');
        }
        else{
            r2.append("d = "+fmt(MainActivity.d));
            r2.append(""+ '\n');
        }
        if (MainActivity.ivelocity.getText().toString().equals("")){
            r2.append(Html.fromHtml("Vi = " + "<font color=green>" + fmt(MainActivity.Vi) +"</font>"));
            r2.append(""+ '\n');
        }
        else{
            r2.append("Vi = "+fmt(MainActivity.Vi));
            r2.append(""+ '\n');
        }
        if (MainActivity.time.getText().toString().equals("")){
            r2.append(Html.fromHtml("t = " + "<font color=green>" + fmt(MainActivity.t) +"</font>"));
            r2.append(""+ '\n');
        }
        else{
            r2.append("t = "+fmt(MainActivity.t));
            r2.append(""+ '\n');
        }
        r2.append("\n"+"");
        filler.setText("\n"+""+"\n"+""+"\n"+"");


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
