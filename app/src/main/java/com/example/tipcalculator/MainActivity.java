package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    SeekBar seekBar;
    TextView text1, text2, text3;
    Button button;
    double total, tip, amount, percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.tv1);
        text2 = (TextView) findViewById(R.id.tv2);
        text3 = (TextView) findViewById(R.id.tv3);
        button = (Button) findViewById(R.id.btn1);
        editText = (EditText) findViewById(R.id.et1);
        seekBar = (SeekBar) findViewById(R.id.skbr1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text1.setText("Tip Percent: " + seekBar.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                percent = seekBar.getProgress();

            }
        });

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().equals("")){

                    text2.setTextColor(Color.YELLOW);
                    text2.setText("Please Enter a value");

                } else{
                    double amount = Double.parseDouble(editText.getText().toString());
                    editText.setTextColor(Color.GRAY);
                    double tip = amount*percent/100;
                    text2.setTextColor(Color.parseColor("#FFF8BE"));
                    text2.setText("Tip Amount:  Rs " +  String.format("%.2f" , tip));
                    double total = amount + tip;
                    text3.setText("Total Bill:  Rs " +  String.format("%.2f" , total));
                }
            }

        });

    }
}
