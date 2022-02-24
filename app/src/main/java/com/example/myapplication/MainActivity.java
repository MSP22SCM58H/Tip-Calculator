package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.zip.CheckedOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityTag";
    private EditText totalBill;
    private TextView tipAmount1,shareperpersoncal,avgcal;
    private TextView totalAmountWithTip;
    private EditText number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalBill = findViewById(R.id.totalBill);
        tipAmount1 = findViewById(R.id.tipAmountCal);
        totalAmountWithTip = findViewById(R.id.totalWithTipcal);
        number = findViewById(R.id.nopeople);
        shareperpersoncal = findViewById(R.id.shareperpersoncal);
        avgcal = findViewById(R.id.avgcal);
    }


    @SuppressLint("DefaultLocale")
    public void doNewGroup(View v){
        double per = 0;
        String message = "";
        if (v.getId() == R.id.percent12){
            per = 12.0;
            message += getString(R.string._12);
        }
        else if(v.getId() == R.id.percent15){
            per = 15.0;
            message += getString(R.string._15);
        }
        else if (v.getId() == R.id.percent18){
            per = 18.0;
            message += getString(R.string._18);
        }
        else if (v.getId() == R.id.percent20){
            per = 20.0;
            message += getString(R.string._20);
        }
        Log.d(TAG, "doNewGroup: " + message);
        Log.d(TAG, "doCal: doCal Function called");
        String tb = totalBill.getText().toString();
        double tb1 = Double.parseDouble(tb);
        double tipAmount  = tb1 * (per/100);
        double tipAmountTotal;
        tipAmountTotal = tb1 + tipAmount;
        Log.d(TAG, "doNewGroup: "+tipAmount);
        Log.d(TAG, "doNewGroup: "+tipAmountTotal);
        tipAmount1.setText(String.format("%.2f",tipAmount));
        totalAmountWithTip.setText(String.format("%.2f",tipAmountTotal));

    }
    @SuppressLint("DefaultLocale")
    public void doCal (View v){
        String number_people = number.getText().toString();
        double np = Double.parseDouble(number_people);
        String t = totalAmountWithTip.getText().toString();
        double tawt = Double.parseDouble(t);
        double shareperperson = (tawt / np)*100;
        Log.d(TAG, "doCal: "+ shareperperson);
        @SuppressLint("DefaultLocale") String val = String.format("%.2f", shareperperson);
        double val1 = Math.ceil(Double.parseDouble(val));
        val1 = val1/ 100;
        Log.d(TAG, "doCal: "+val1);
        shareperpersoncal.setText(String.format("%.2f", val1));
        double val3 = val1*np - tawt;
        avgcal.setText(String.format("%.2f",val3));
    }

    public void doClear(View v){
        Log.d(TAG, "doClear: ");
        totalBill.setText("");
        tipAmount1.setText("");
        totalAmountWithTip.setText("");
        number.setText("");
        shareperpersoncal.setText("");
        avgcal.setText("");
    }

}