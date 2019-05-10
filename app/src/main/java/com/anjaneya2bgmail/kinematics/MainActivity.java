package com.anjaneya2bgmail.kinematics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    EditText acceleration,time,distance,fvelocity,ivelocity;
    Button solve;
    Button redoBtn;
    public TextView result;
    Button clearBtn;
    Double a,t,d,Vf,Vi;
    private AdView rAdView;
    Stack<String[]> redoStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713"); //test id

        rAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        rAdView.loadAd(adRequest);
        acceleration = (EditText)findViewById(R.id.acceleration);
        time = (EditText)findViewById(R.id.time);
        distance = (EditText)findViewById(R.id.distance);
        fvelocity = (EditText)findViewById(R.id.fvelocity);
        ivelocity = (EditText)findViewById(R.id.ivelocity);
        solve = (Button)findViewById(R.id.solve);
        clearBtn = (Button)findViewById(R.id.clearBtn);
        redoBtn = findViewById(R.id.redoBtn);
        redoStack = new Stack<>();

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = null;
                t = null;
                d = null;
                Vf = null;
                Vi = null;
                if (fvelocity.length() != 0) {
                    Vf = Double.parseDouble(fvelocity.getText().toString());
                }if (ivelocity.length() != 0) {
                    Vi = Double.parseDouble(ivelocity.getText().toString());
                }if (distance.length() != 0) {
                    d = Double.parseDouble(distance.getText().toString());
                }if (acceleration.length() != 0) {
                    a = Double.parseDouble(acceleration.getText().toString());
                }if (time.length() != 0) {
                    t = Double.parseDouble(time.getText().toString());
                }

                Algorithm calc = null;
                if (fvelocity.length()==0 && ivelocity.length()==0 && distance.length()==0 && time.length()==0&& acceleration.length()==0) {
                    Toast.makeText(MainActivity.this, "No input values", Toast.LENGTH_SHORT).show();
                } else if (fvelocity.length()!=0 && ivelocity.length()!=0 && distance.length()!=0 && time.length()!=0&& acceleration.length()!=0) {
                    Toast.makeText(MainActivity.this, "No unknowns", Toast.LENGTH_SHORT).show();
                    result.setText("");
                } else if (acceleration.length() == 0) {
                    calc = new Acceleration(Vi, t, Vf, d, a);
                }
                else if (time.length()==0) {
                    calc = new Time(Vi, t, Vf, d, a);
                } else if (distance.length()==0){
                    calc = new Distance(Vi, t, Vf, d, a);
                } else if (ivelocity.length()==0){
                    calc = new IVelocity(Vi, t, Vf, d, a);
                } else if (fvelocity.length()==0){
                    calc = new FVelocity(Vi, t, Vf, d, a);
                } else {
                    ErrorText();
                }if (calc != null) {
                    boolean done = calc.solve();
                    if(done) {
                        Vf = calc.getVf(); Vi = calc.getVi(); t = calc.getT(); a = calc.getA(); d = calc.getD();
                        switchResults();
                    } else {
                        ErrorText();
                    }
                }
                }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(fvelocity.length()==0 && ivelocity.length()==0 && distance.length()==0 && time.length()==0&& acceleration.length()==0)) {
                    String[] values = new String[5];
                    values[0] = acceleration.getText().toString();
                    values[1] = fvelocity.getText().toString();
                    values[2] = distance.getText().toString();
                    values[3] = ivelocity.getText().toString();
                    values[4] = time.getText().toString();
                    redoStack.push(values);
                }
                acceleration.setText("");
                time.setText("");
                distance.setText("");
                fvelocity.setText("");
                ivelocity.setText("");
            }
        });
        redoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (redoStack.empty())
                    RedoText();
                else {
                    String[] values = redoStack.pop();
                    acceleration.setText(values[0]);
                    fvelocity.setText(values[1]);
                    distance.setText(values[2]);
                    ivelocity.setText(values[3]);
                    time.setText(values[4]);
                }

            }
        });
    }



    public void switchResults(){
        Bundle extras = new Bundle();
        extras.putString("acceleration", acceleration.getText().toString());
        extras.putString("time", time.getText().toString());
        extras.putString("distance", distance.getText().toString());
        extras.putString("ivelocity", ivelocity.getText().toString());
        extras.putString("fvelocity", fvelocity.getText().toString());
        extras.putDouble("a", a);
        extras.putDouble("t", t);
        extras.putDouble("d", d);
        extras.putDouble("iv", Vi);
        extras.putDouble("fv", Vf);
        Intent intent = new Intent(MainActivity.this, solDisplay.class);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void ErrorText(){
        Toast.makeText(this, "Error with values", Toast.LENGTH_SHORT).show();
    }

    public void RedoText(){
        Toast.makeText(this, "Nothing to Redo", Toast.LENGTH_SHORT).show();
    }

}
