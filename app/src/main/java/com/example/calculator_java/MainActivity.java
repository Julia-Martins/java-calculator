package com.example.calculator_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txt_num1, txt_num2, txt_result;
    private Button btn_clear;
    private CheckBox check_plus, check_minus, check_mult, check_divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_num1 = (EditText) findViewById(R.id.txtAppCompat_num1);
        txt_num2 = (EditText) findViewById(R.id.txtAppCompat_num2);
        txt_result = (EditText) findViewById(R.id.txt_result);

        check_plus = (CheckBox) findViewById(R.id.check_operations_plus);
        check_minus = (CheckBox) findViewById(R.id.check_operations_minus);
        check_mult = (CheckBox) findViewById(R.id.check_operations_mult);
        check_divide = (CheckBox) findViewById(R.id.check_operations_divide);

        Button btn_calculate = (Button) findViewById(R.id.btn_calculate);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        check_plus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    check_minus.setChecked(false);
                    check_mult.setChecked(false);
                    check_divide.setChecked(false);
                }
            }
        });

        check_minus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    check_plus.setChecked(false);
                    check_mult.setChecked(false);
                    check_divide.setChecked(false);
                }
            }
        });

        check_mult.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    check_plus.setChecked(false);
                    check_minus.setChecked(false);
                    check_divide.setChecked(false);
                }
            }
        });

        check_divide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    check_plus.setChecked(false);
                    check_mult.setChecked(false);
                    check_minus.setChecked(false);
                }
            }
        });

        btn_calculate.setOnClickListener(view -> {
            String num1Text = txt_num1.getText().toString().trim();
            String num2Text = txt_num2.getText().toString().trim();

            if(!num1Text.isEmpty() && !num2Text.isEmpty()){
                onClick(btn_calculate);
            }else {
                Toast.makeText(
                        this,
                        "You need to enter some numbers",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
//        }

        btn_clear.setOnClickListener(view -> {
            onClear(btn_clear);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    public void onClick(View view) {
        Answer();
    }

    private void Answer(){
        String num1Text = txt_num1.getText().toString();
        String num2Text = txt_num2.getText().toString();

        double num1 = Double.parseDouble(num1Text);
        double num2 = Double.parseDouble(num2Text);
        double result = 0;

        boolean option = false;
        boolean check_plus = this.check_plus.isChecked();
        boolean check_minus = this.check_minus.isChecked();
        boolean check_mult = this.check_mult.isChecked();
        boolean check_divide = this.check_divide.isChecked();
        boolean btn_clear = this.btn_clear.callOnClick();

        if (!check_divide && !check_mult && !check_minus && !check_plus) {
            txt_num1.setText(String.valueOf(num1));
            txt_num2.setText(String.valueOf(num2));

            Toast.makeText(
                    this,
                    "Select some operation",
                    Toast.LENGTH_LONG
            ).show();

        }else {
            try {

                if (check_plus) {
                    result = num1 + num2;
                    txt_result.setText(String.valueOf(result));

                } else if (check_minus) {
                    result = num1 - num2;
                    txt_result.setText(String.valueOf(result));

                } else if (check_mult) {
                    result = num1 * num2;
                    txt_result.setText(String.valueOf(result));

                } else {
                    result = num1 / num2;
                    txt_result.setText(String.valueOf(result));
                }

            }catch (Exception e){
                txt_num1.setText(String.valueOf(num1));
                txt_num2.setText(String.valueOf(num2));

                Toast.makeText(
                        this,
                        "Conversation can't complete",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }

        txt_num1.clearFocus();
        txt_num2.clearFocus();
    }

    private void onClear(View view){
        txt_num1.setText("");
        txt_num2.setText("");
        txt_result.setText("");

        check_plus.setChecked(false);
        check_minus.setChecked(false);
        check_mult.setChecked(false);
        check_divide.setChecked(false);

        txt_num1.clearFocus();
        txt_num2.clearFocus();
    }

}