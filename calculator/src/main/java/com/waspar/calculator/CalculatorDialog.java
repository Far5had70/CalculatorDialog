package com.waspar.calculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculatorDialog extends DialogFragment {

    private View view, root, framel;
    private boolean cancelable = true;
    private float alertRadius = 80;
    private Listener listener;
    private Typeface typeFace;
    private String number = "";
    private String textButton = "ثبت";
    private int backgroundColor = 0;
    private int buttonsTextColor = 0;

    TextView button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonC, buttonEqual, button00, button000, Submit;
    ImageView Back;
    EditText crunchifyEditText;

    int mValueOne, mValueTwo;

    boolean crunchifyAddition, mSubtract, crunchifyMultiplication, crunchifyDivision;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_calculator, container, false);
        show();
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(cancelable);
        return view;
    }

    private void show() {
        init();

    }

    @SuppressLint("SetTextI18n")
    private void init() {
        button0 = view.findViewById(R.id.button0);
        button00 = view.findViewById(R.id.button00);
        button000 = view.findViewById(R.id.button000);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);
        button7 = view.findViewById(R.id.button7);
        button8 = view.findViewById(R.id.button8);
        button9 = view.findViewById(R.id.button9);
        buttonAdd = view.findViewById(R.id.buttonadd);
        buttonSub = view.findViewById(R.id.buttonsub);
        buttonMul = view.findViewById(R.id.buttonmul);
        Back = view.findViewById(R.id.buttonBack);
        buttonDivision = view.findViewById(R.id.buttondiv);
        buttonC = view.findViewById(R.id.buttonC);
        buttonEqual = view.findViewById(R.id.buttoneql);
        crunchifyEditText = view.findViewById(R.id.edt1);
        root = view.findViewById(R.id.calc_root);
        Submit = view.findViewById(R.id.buttonSubmit);
        framel = view.findViewById(R.id.frameLayout);

        crunchifyEditText.setOnTouchListener(otl);
        crunchifyEditText.setFocusable(false);

        if (buttonsTextColor != 0) {
            setButtonTextColor(button0);
            setButtonTextColor(button00);
            setButtonTextColor(button000);
            setButtonTextColor(button1);
            setButtonTextColor(button2);
            setButtonTextColor(button3);
            setButtonTextColor(button4);
            setButtonTextColor(button5);
            setButtonTextColor(button6);
            setButtonTextColor(button7);
            setButtonTextColor(button8);
            setButtonTextColor(button9);
            setButtonTextColor(buttonAdd);
            setButtonTextColor(buttonSub);
            setButtonTextColor(buttonMul);
            setButtonTextColor(buttonDivision);
            setButtonTextColor(buttonEqual);
            setButtonTextColor(crunchifyEditText);
            setButtonTextColor(Submit);
            setButtonTextColor(buttonC);
            framel.setBackgroundColor(buttonsTextColor);
            crunchifyEditText.getBackground().mutate().setColorFilter(buttonsTextColor, PorterDuff.Mode.SRC_ATOP);
            Back.setColorFilter(buttonsTextColor);
        }

        button0.setTypeface(typeFace);
        button00.setTypeface(typeFace);
        button000.setTypeface(typeFace);
        button1.setTypeface(typeFace);
        button2.setTypeface(typeFace);
        button3.setTypeface(typeFace);
        button4.setTypeface(typeFace);
        button5.setTypeface(typeFace);
        button6.setTypeface(typeFace);
        button7.setTypeface(typeFace);
        button8.setTypeface(typeFace);
        button9.setTypeface(typeFace);
        buttonAdd.setTypeface(typeFace);
        buttonSub.setTypeface(typeFace);
        buttonMul.setTypeface(typeFace);
        buttonDivision.setTypeface(typeFace);
        buttonEqual.setTypeface(typeFace);
        crunchifyEditText.setTypeface(typeFace);
        Submit.setTypeface(typeFace);

        if (!number.equals("")) {
            crunchifyEditText.setText("" + number);
        }

        Submit.setText(textButton);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "0");
            }
        });

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "00");
            }
        });

        button000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "000");
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    crunchifyEditText.setText(removeLastChar(crunchifyEditText.getText().toString()));
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action();
                try {
                    if (crunchifyEditText == null) {
                        crunchifyEditText.setText("");
                    } else {
                        mValueOne = Integer.parseInt(crunchifyEditText.getText() + "");
                        crunchifyAddition = true;
                        crunchifyEditText.setText(null);
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action();
                try {
                    mValueOne = Integer.parseInt(crunchifyEditText.getText() + "");
                    mSubtract = true;
                    crunchifyEditText.setText(null);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action();
                try {
                    mValueOne = Integer.parseInt(crunchifyEditText.getText() + "");
                    crunchifyMultiplication = true;
                    crunchifyEditText.setText(null);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action();
                try {
                    mValueOne = Integer.parseInt(crunchifyEditText.getText() + "");
                    crunchifyDivision = true;
                    crunchifyEditText.setText(null);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText("");
            }
        });


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                action();

                if (crunchifyEditText.getText().length() != 0) {
                    listener.OnSelectListener(Integer.parseInt(crunchifyEditText.getText().toString()));
                } else {
                    listener.OnSelectListener(0);
                }
                dismiss();
            }
        });

    }

    private void setButtonTextColor(TextView button) {
        button.setTextColor(buttonsTextColor);
    }

    private void action() {
        try {
            mValueTwo = Integer.parseInt(crunchifyEditText.getText() + "");

            if (crunchifyAddition == true) {
                crunchifyEditText.setText(mValueOne + mValueTwo + "");
                crunchifyAddition = false;
            }

            if (mSubtract == true) {
                crunchifyEditText.setText(mValueOne - mValueTwo + "");
                mSubtract = false;
            }

            if (crunchifyMultiplication == true) {
                crunchifyEditText.setText(mValueOne * mValueTwo + "");
                crunchifyMultiplication = false;
            }

            if (crunchifyDivision == true) {
                crunchifyEditText.setText(mValueOne / mValueTwo + "");
                crunchifyDivision = false;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private View.OnTouchListener otl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    };

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT - 1;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        GradientDrawable bgShape = new GradientDrawable();

        bgShape.setCornerRadius(alertRadius);
        if (backgroundColor != 0) {
            bgShape.setColor(backgroundColor);
        } else {
            bgShape.setColor(getActivity().getResources().getColor(R.color.calc_white));
        }
        root.setBackground(bgShape);
    }


    public CalculatorDialog setListener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public CalculatorDialog setTypeFace(Typeface typeFace) {
        this.typeFace = typeFace;
        return this;
    }

    public CalculatorDialog setAlertRadius(int alertRadius) {
        this.alertRadius = alertRadius;
        return this;
    }

    public CalculatorDialog setCalc(String number) {
        this.number = number;
        return this;
    }

    public CalculatorDialog setTextButton(String textButton) {
        this.textButton = textButton;
        return this;
    }

    public CalculatorDialog setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public CalculatorDialog setButtonsTextColor(int buttonsTextColor) {
        this.buttonsTextColor = buttonsTextColor;
        return this;
    }

}


