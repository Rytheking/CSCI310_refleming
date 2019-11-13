package com.example.tip_calc;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static SeekBar seek_bar;
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


        return (bill*grat);
    }

    public void doStuff(){

        custom_percent =findViewById(R.id.custom_percent);
        tip_amount=findViewById(R.id.Tip_amount);
        bill_total=findViewById(R.id.input_bill);
        seek_bar=findViewById(R.id.seekBar);
        Button tenpercent=findViewById(R.id.ten_percent);
        Button fifteenpercent=findViewById(R.id.fifteen_percent);
        Button twentypercent=findViewById(R.id.twenty_percent);


        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub

                custom_percent.setText(String.valueOf(progress));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                if (!bill_total.getText().toString().equals("") && !custom_percent.getText().toString().equals("")) {
                    tip_amount.setText("Tip Amount: $" + calc(Double.parseDouble(bill_total.getText().toString()), (Double.parseDouble(custom_percent.getText().toString()) / 100)));
                } else {
                    if (custom_percent.getText().toString().equals("")&&!bill_total.getText().toString().equals("")) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Gratuity can't be 0%!", Toast.LENGTH_SHORT);
                        toast.show();
                    } else if(bill_total.getText().toString().equals("")){

                        Toast toast = Toast.makeText(getApplicationContext(), "Total is 0!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });


        tenpercent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!bill_total.getText().toString().equals("")) {
                    tip_amount.setText("Tip Amount: $" + calc(Double.parseDouble(bill_total.getText().toString()), .1));
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Total is 0!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        fifteenpercent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(!bill_total.getText().toString().equals("")) {
                    tip_amount.setText("Tip Amount: $" + calc(Double.parseDouble(bill_total.getText().toString()), .15));
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Total is 0!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        twentypercent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(!bill_total.getText().toString().equals("")) {
                    tip_amount.setText("Tip Amount: $" + calc(Double.parseDouble(bill_total.getText().toString()), .2));
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Total is 0!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });




    }


}
