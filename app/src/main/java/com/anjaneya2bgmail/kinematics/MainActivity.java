package com.anjaneya2bgmail.kinematics;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;

import static com.anjaneya2bgmail.kinematics.R.id.resultt;

public class MainActivity extends AppCompatActivity {

    static EditText acceleration,time,distance,fvelocity,ivelocity;
    Button solve;
    Button clearBtn;
    TextView result;
    static Double a,t,d,Vf,Vi;
    private AdView rAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acceleration = (EditText)findViewById(R.id.acceleration);
        time = (EditText)findViewById(R.id.time);
        distance = (EditText)findViewById(R.id.distance);
        fvelocity = (EditText)findViewById(R.id.fvelocity);
        ivelocity = (EditText)findViewById(R.id.ivelocity);
        solve = (Button)findViewById(R.id.solve);
        clearBtn = (Button)findViewById(R.id.clearBtn);

        result = (TextView)findViewById(resultt);

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                if (fvelocity.length()==0 && ivelocity.length()==0 && distance.length()==0 && time.length()==0&& acceleration.length()==0) {
                    result.setTextColor(Color.BLACK);
                    result.setText("No input values.");
                }
                else if (acceleration.length() == 0) {
                    if (fvelocity.length()!=0 && ivelocity.length()!=0 && distance.length()!=0 && time.length()!=0) {
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        d = Double.parseDouble(distance.getText().toString());
                        t = Double.parseDouble(time.getText().toString());
                        a= (d-(Vi*t))/((1.0/2.0)*(t*t));
                        switchResults();
                    }
                    else if (ivelocity.length() !=0 && time.length() !=0 && distance.length() !=0){
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        t = Double.parseDouble(time.getText().toString());
                        d = Double.parseDouble(distance.getText().toString());
                        a = ((d-(Vi*t)/((0.5)*(t*t))));
                        Vf = Math.sqrt((Vi*Vi)+(2*a*d));
                        switchResults();
                    }
                    else if (fvelocity.length()!=0 && ivelocity.length()!=0 && time.length()!=0) {
                        t = Double.parseDouble(time.getText().toString());
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        a = (Vf - Vi) / t;
                        d = (t*(Vi+Vf))/2;
                        switchResults();
                    }
                    else if (fvelocity.length()!=0 && ivelocity.length()!=0 && distance.length()!=0) {
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        d = Double.parseDouble(distance.getText().toString());
                        a= ((Vf*Vf)-(Vi*Vi))/(2.0*d);
                        t=(Vf-Vi)/a;
                        switchResults();
                    }
                    else if (fvelocity.length()!=0 && time.length()!=0 && distance.length()!=0) {
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        t = Double.parseDouble(time.getText().toString());
                        d = Double.parseDouble(distance.getText().toString());
                        Vi= ((2*d)-(t*Vf))/t;
                        a = (d-(Vi*t))/((1.0/2.0)*(t*t));
                        switchResults();
                    }
                    else if (ivelocity.length()!=0 && time.length()!=0 && distance.length()!=0) {
                        Vi = Double.parseDouble(fvelocity.getText().toString());
                        t = Double.parseDouble(time.getText().toString());
                        d = Double.parseDouble(distance.getText().toString());
                        a = (d-(Vi*t))/((1.0/2.0)*(t*t));
                        Vf = Math.sqrt((Vi*Vi)+(2.0*a*d));
                        switchResults();
                    }
                    else{
                        ErrorText();
                    }
                }
                else if (time.length()==0) {
                    if (fvelocity.length() != 0 && ivelocity.length() != 0 && acceleration.length() != 0 && distance.length() != 0) {
                        d = Double.parseDouble(distance.getText().toString());
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        t = (Vf - Vi) / a;
                        switchResults();
                    }
                    else if (fvelocity.length() != 0 && ivelocity.length() != 0 && acceleration.length() != 0) {
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        d = ((Vf * Vf) - (Vi * Vi)) / (2.0 * a);
                        t = (Vf - Vi) / a;
                        switchResults();
                    }
                    else if (fvelocity.length() != 0 && acceleration.length() != 0 && distance.length() != 0) {
                        d = Double.parseDouble(distance.getText().toString());
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        ErrorText();
                    }
                    else if (ivelocity.length() != 0 && acceleration.length() != 0 && distance.length() != 0) {
                        d = Double.parseDouble(distance.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        Vf = Math.sqrt((Vi * Vi) + (2.0 * a * d));
                        t = (Vf - Vi) / a;
                        switchResults();
                    } else {
                        ErrorText();
                    }
                }
                else if (distance.length()==0){
                    if (fvelocity.length() != 0 && ivelocity.length() != 0 && acceleration.length() != 0 && time.length() != 0) {
                        t = Double.parseDouble(time.getText().toString());
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        d = ((Vi * t) + ((1.0 / 2.0) * (a * (t*t))));
                        switchResults();
                    }
                    else if (fvelocity.length() != 0 && acceleration.length() != 0 && time.length() != 0) {
                        t = Double.parseDouble(time.getText().toString());
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        Vi = Vf-(a*t);
                        d = (t*(Vi+Vf))/2;
                        switchResults();
                        }
                    else if (ivelocity.length() != 0 && acceleration.length() != 0 && time.length() != 0) {
                        t = Double.parseDouble(time.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        Vf = Vi+(a*t);
                        d = (Vi*t)+((1.0/2.0)*(a*(t*t)));
                        switchResults();
                    }
                    else if (ivelocity.length() != 0 && acceleration.length() != 0 && fvelocity.length() != 0) {
                        a = Double.parseDouble(acceleration.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        t = (Vf-Vi)/a;
                        d = ((Vf*Vf)-(Vi*Vi))/(2*a);
                        switchResults();
                    }
                    else {
                        ErrorText();
                    }
                }
                else if (ivelocity.length()==0){
                    if (fvelocity.length() != 0 && distance.length() != 0 && acceleration.length() != 0 && time.length() != 0) {
                        t = Double.parseDouble(time.getText().toString());
                        Vf = Double.parseDouble(fvelocity.getText().toString());
                        d = Double.parseDouble(distance.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        Vi = (d-((1.0/2.0)*a*(t*t)))/t;
                        switchResults();
                    }
                    else if (distance.length() != 0 && acceleration.length() != 0 && time.length() != 0) {
                        t = Double.parseDouble(time.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        d = Double.parseDouble(distance.getText().toString());
                        Vi = d-((1.0/2.0)*a*(t*t))/t;
                        Vf = Math.sqrt((Vi * Vi) + (2.0 * a * d));
                        switchResults();
                    }
                    else {
                        ErrorText();
                    }
                }
                else if (fvelocity.length()==0){
                    if (ivelocity.length() != 0 && distance.length() != 0 && acceleration.length() != 0 && time.length() != 0) {
                        t = Double.parseDouble(time.getText().toString());
                        Vi = Double.parseDouble(ivelocity.getText().toString());
                        d = Double.parseDouble(distance.getText().toString());
                        a = Double.parseDouble(acceleration.getText().toString());
                        Vf = Math.sqrt((Vi * Vi) + (2.0 * a * d));
                        switchResults();
                    }
                    else {
                        ErrorText();
                    }
                }
                else {
                    ErrorText();
                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceleration.setText("");
                time.setText("");
                distance.setText("");
                fvelocity.setText("");
                ivelocity.setText("");
                result.setText("");
            }
        });
    }
    public void switchResults(){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
    public void ErrorText(){
        result.setTextColor(Color.RED);
        result.setText("Error");
    }

}
