package com.example.tip_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.util.Log;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private static TextView text_view;
    EditText tip_amount;
    EditText bill_total;
    EditText custom_percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doStuff();
    }

    public double calc(double bill, double grat){
        return bill*grat;
    }

    public void doStuff(){

        custom_percent =findViewById(R.id.custom_percent);
        tip_amount=findViewById(R.id.Tip_amount);
        bill_total=findViewById(R.id.input_bill);
        Button tenpercent=findViewById(R.id.ten_percent);
        Button fifteenpercent=findViewById(R.id.fifteen_percent);
        Button twentypercent=findViewById(R.id.twenty_percent);
        Button calculate=findViewById(R.id.calculate);

        tenpercent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tip_amount.setText("Tip Amount: $"+ calc(Double.parseDouble(bill_total.getText().toString()),.1));
            }
        });
        fifteenpercent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tip_amount.setText("Tip Amount: $"+ calc(Double.parseDouble(bill_total.getText().toString()),.1));
            }
        });
        twentypercent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tip_amount.setText("Tip Amount: $"+ calc(Double.parseDouble(bill_total.getText().toString()),.1));
            }
        });
        calculate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tip_amount.setText("Tip Amount: $"+ calc(Double.parseDouble(bill_total.getText().toString()),(Double.parseDouble(custom_percent.getText().toString())/100)));
            }
        });

    }


}
