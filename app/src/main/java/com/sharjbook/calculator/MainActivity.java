package com.sharjbook.calculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.waspar.calculator.CalculatorDialog;
import com.waspar.calculator.Listener;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private View calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculatorDialog calculatorDialog = new CalculatorDialog()
                        .setAlertRadius(30)
                        .setCalc(editText.getText().toString())
                        .setTextButton("ثبت")
                        .setBackgroundColor(getResources().getColor(R.color.colorPrimary))
                        .setButtonsTextColor(getResources().getColor(R.color.calc_white))
                        .setTypeFace(Typeface.createFromAsset(getAssets(), "bsans.ttf"))
                        .setListener(new Listener() {
                            @Override
                            public void OnSelectListener(int result) {
                                editText.setText(""+result);
                            }
                        });
                calculatorDialog.show(getSupportFragmentManager() , "");
            }
        });

    }

    private void init() {
        editText = findViewById(R.id.edt);
        calc = findViewById(R.id.calc_view);
    }
}
