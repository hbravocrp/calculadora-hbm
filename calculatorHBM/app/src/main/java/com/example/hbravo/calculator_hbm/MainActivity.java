package com.example.hbravo.calculator_hbm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_zero, button_one , button_two , button_three , button_four , button_five, button_six,
            button_seven, button_eight, button_nine, button_sum, button_diff, button_div, button_mult , button_del ,
            button_equal , button_dot, button_per, button_back, button_square, button_pi, button_cube_root, button_super_squared, button_super_cubed;

    private EditText editText_display;
    BigDecimal first_number;
    BigDecimal two_number;
    String aux_number = "";
    String operator;
    private int scale = 4;
    private StringBuffer str_show = new StringBuffer("");
    private boolean flag_num1 = false;
    private boolean flag_num2 = false;
    private String str_result = null;
    private boolean flag_minus = false;
    private boolean flag_dot = true;
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    private static final String SAVED_INSTANCE_STATE_KEY_RESULT = "result";
    private static final String SAVED_INSTANCE_STATE_KEY_FIRST_NUMBER = "first_number";
    private static final String SAVED_INSTANCE_STATE_KEY_OPERATOR = "operator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar Valores
        button_zero = (Button) findViewById(R.id.btn_zero);
        button_one = (Button) findViewById(R.id.btn_one);
        button_two = (Button) findViewById(R.id.btn_two);
        button_three = (Button) findViewById(R.id.btn_three);
        button_four = (Button) findViewById(R.id.btn_four);
        button_five = (Button) findViewById(R.id.btn_five);
        button_six = (Button) findViewById(R.id.btn_six);
        button_seven = (Button) findViewById(R.id.btn_seven);
        button_eight = (Button) findViewById(R.id.btn_eight);
        button_nine = (Button) findViewById(R.id.btn_nine);
        button_dot = (Button) findViewById(R.id.btn_dot);

        button_sum = (Button) findViewById(R.id.btn_sum);
        button_diff = (Button) findViewById(R.id.btn_diff);
        button_mult = (Button) findViewById(R.id.btn_multiple);
        button_div = (Button) findViewById(R.id.btn_divide);
        button_del = (Button) findViewById(R.id.btn_delete);
        button_equal = (Button) findViewById(R.id.btn_equal);
        button_per = (Button) findViewById(R.id.btn_percentage);
        button_back = (Button) findViewById(R.id.btn_back);
        button_square = (Button) findViewById(R.id.btn_square);
        button_pi = (Button) findViewById(R.id.btn_pi);
        button_cube_root = (Button) findViewById(R.id.btn_cube_root);

        button_super_squared = (Button) findViewById(R.id.btn_super_squared);
        button_super_cubed = (Button) findViewById(R.id.btn_super_cubed);





        editText_display = (EditText) findViewById(R.id.editText_display);

        try {
            button_zero.setOnClickListener(this);
            button_one.setOnClickListener(this);
            button_two.setOnClickListener(this);
            button_three.setOnClickListener(this);
            button_four.setOnClickListener(this);
            button_five.setOnClickListener(this);
            button_six.setOnClickListener(this);
            button_seven.setOnClickListener(this);
            button_eight.setOnClickListener(this);
            button_nine.setOnClickListener(this);
            button_equal.setOnClickListener(this);
            button_div.setOnClickListener(this);
            button_mult.setOnClickListener(this);
            button_diff.setOnClickListener(this);
            button_sum.setOnClickListener(this);
            button_dot.setOnClickListener(this);
            button_per.setOnClickListener(this);
            button_back.setOnClickListener(this);
            button_back.setOnClickListener(this);
            button_square.setOnClickListener(this);
            button_pi.setOnClickListener(this);
            button_cube_root.setOnClickListener(this);
            button_super_cubed.setOnClickListener(this);
            button_super_squared.setOnClickListener(this);

            button_del.setOnClickListener(this);
            button_del.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    editText_display.setText("");
                    str_show = new StringBuffer("");
                    flag_dot = true;
                    flag_num1 = false;
                    flag_num2 = false;
                    flag_minus = false;
                    operator = null;
                    return true;


                }
            });

        }
        catch (Exception e)
        {

        }
    }

    @Override
    public void onClick(View v) {

        Button btn = (Button) v;
        System.out.println("BUTTON:"+btn);

        switch (v.getId()) {
            case R.id.btn_one:
                printText(button_one);

                break;

            case R.id.btn_two:
                printText(button_two);
                break;

            case R.id.btn_three:
                printText(button_three);
                break;

            case R.id.btn_four:
                printText(button_four);
                break;

            case R.id.btn_five:
                printText(button_five);
                break;

            case R.id.btn_six:
                printText(button_six);
                break;

            case R.id.btn_seven:
                printText(button_seven);
                break;

            case R.id.btn_eight:
                printText(button_eight);
                break;

            case R.id.btn_nine:
                printText(button_nine);
                break;

            case R.id.btn_zero:
                printText(button_zero);
                break;

            case R.id.btn_dot:
                if (str_show.toString() == "") {
                    break;
                } else if (flag_dot) {
                    str_show.append(".");
                    showInTextView(str_show.toString());
                    flag_dot = false;
                }
                break;

            case R.id.btn_back:
                System.out.println("LENGHT: "+str_show.length());
                if (!(str_show.toString() == "")) {
                    if (!flag_dot) {
                        String lastStr = String.valueOf(str_show.charAt(str_show.length() - 1));
                        if (lastStr.equals(".")) {
                            flag_dot = true;
                        }
                    }
                    str_show.deleteCharAt(str_show.length() - 1);
                    if(str_show.toString().equals("")){
                        flag_minus = false;
                    }
                    showInTextView(str_show.toString());
                } else {
                    showInTextView("");
                    str_result = null;
                    str_show = new StringBuffer("");
                    flag_dot = true;
                    flag_minus = false;
                }
                flag_num1 = false;
                break;

            case R.id.btn_sum:
                setNum1(btn.getText().toString());
                break;
            case R.id.btn_diff:
                if (!flag_minus) {
                    if (str_show.toString().equals("")) {
                        str_show.append("-");
                        showInTextView(str_show.toString());
                        flag_minus = true;
                        break;
                    }
                }
                setNum1(btn.getText().toString());

                break;

            case R.id.btn_equal:
                if (operator == null || str_show.toString().equals("") || !flag_num1)
                {
                    break;
                }
                calculate();
                break;

            case R.id.btn_multiple:
                setNum1(btn.getText().toString());
                break;

            case R.id.btn_divide:
                setNum1(btn.getText().toString());
                break;

            case R.id.btn_percentage:
                operator = btn.getText().toString();
                calculate();
                break;

            case R.id.btn_delete:
                System.out.println("DELTE");
                editText_display.setText("");
                str_show = new StringBuffer("");
                aux_number = new String();
                flag_dot = true;
                flag_num1 = false;
                flag_num2 = false;
                flag_minus = false;
                operator = null;
                break;

            case R.id.btn_square:
                if(!aux_number.equals(""))
                {
                    first_number = new BigDecimal(aux_number);
                    operator = btn.getText().toString();
                    calculate();
                }
                else
                {
                    editText_display.setText("");
                }

                break;

            case R.id.btn_pi:
                Double pi = Math.PI;
                first_number = new BigDecimal(pi);

                pi = Double.valueOf(round(pi, scale));
                str_show = new StringBuffer(pi.toString());
                editText_display.setText(pi.toString());
                break;

            case R.id.btn_super_squared:
                if(!aux_number.equals(""))
                {
                    first_number = new BigDecimal(aux_number);
                    operator = btn.getText().toString();
                    calculate();
                }
                else
                {
                    editText_display.setText("");
                }

                break;

            case R.id.btn_super_cubed:
                if(!aux_number.equals(""))
                {
                    first_number = new BigDecimal(aux_number);
                    operator = btn.getText().toString();
                    calculate();
                }
                else
                {
                    editText_display.setText("");
                }

                break;

        }
    }

    private void printText(Button btn)
    {
        str_show.append(btn.getText().toString());
        showInTextView(str_show.toString());
        aux_number = btn.getText().toString();
    }

    private void showInTextView(String str) {

        editText_display.setText(str);
    }

    private void appendDecimal(Button b)
    {
        Editable str =  editText_display.getText();

        if(!two_number.equals(BigDecimal.ZERO))
        {
            two_number = new BigDecimal("0");
            editText_display.setText("");
        }
        str = str.append(b.getText());
        str = str.append(".");
        editText_display.setText(str);
    }


    public void calculate()
    {
//        Log.d("Número 1", first_number.toString());
//        Log.d("Número 2", two_number.toString());

        System.out.println("1:"+first_number);
        System.out.println(operator);

        if(str_show.toString().equals("-")) return;
        double result = 0;
        two_number = new BigDecimal(str_show.toString());
        flag_num2 = true;


        if (operator.equals("+")) {
            result = add(first_number, two_number);
        }
        if (operator.equals("-")) {
            result = sub(first_number, two_number);
        }
        if (operator.equals("x")) {
            result = mul(first_number, two_number);
        }

        if (operator.equals("%")) {
            if (!two_number.equals(BigDecimal.ZERO)) {
                result = per(first_number, two_number);
            }
            else
            {
                result = 0;
                return;
            }
        }

        if (operator.equals("√")) {
            if (!first_number.equals(BigDecimal.ZERO)) {
                result = square(first_number);
            }
            else
            {
                result = 0;
                return;
            }
        }

        if (operator.equals("²")) {
            if (!first_number.equals(BigDecimal.ZERO)) {
                result = super_squares(first_number);
            }
            else
            {
                result = 0;
                return;
            }
        }

        if (operator.equals("³")) {
            if (!first_number.equals(BigDecimal.ZERO)) {
                result = super_cubes(first_number);
            }
            else
            {
                result = 0;
                return;
            }
        }

        if (operator.equals("∛")) {
            if (!first_number.equals(BigDecimal.ZERO)) {
                result = cube_root(first_number);
            }
            else
            {
                result = 0;
                return;
            }
        }



        if (operator.equals("/")) {
            if (!two_number.equals(BigDecimal.ZERO)) {
                result = div(first_number, two_number, scale);
            } else {
                Toast.makeText(this, "ERROR", Toast.LENGTH_LONG)
                        .show();
                showInTextView("");
                str_show = new StringBuffer("");
                operator = null;
                flag_num1 = false;
                flag_dot = true;
                return;
            }
        }
        str_result = String.valueOf(round(result, scale));
        String[] resultStrings = str_result.split("\\.");
        if (resultStrings[1].equals("0")) {
            str_result = resultStrings[0];
        }
        showInTextView(str_result);
        //str_show = new StringBuffer("");

        //HBM
        System.out.println(result);
        str_show = new StringBuffer(str_result);
        first_number = new BigDecimal(result);
        aux_number = str_result;
        flag_num1 = true;
        flag_num2 = false;

        flag_dot = true;
//      flag_num1 = false;
        operator = null;
        flag_minus = true;
    }

    // Calculator
    public void setScale(int scale) {
        this.scale = scale;
    }

    public static double add(BigDecimal num1,BigDecimal num2) {
        return num1.add(num2).doubleValue();
    }

    public static double sub(BigDecimal num1,BigDecimal num2) {
        return num1.subtract(num2).doubleValue();
    }

    public static double mul(BigDecimal num1,BigDecimal num2) {
        return num1.multiply(num2).doubleValue();
    }

    public static double div(BigDecimal num1,BigDecimal num2, int scale) {
        return num1.divide(num2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double per(BigDecimal num1,BigDecimal num2) {
        return num1.multiply(num2).divide(ONE_HUNDRED).doubleValue();
    }


    public static double round(Double result, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(result));
        BigDecimal one = new BigDecimal(1);
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public  static double square(BigDecimal num1)
    {
        return (double) Math.sqrt(num1.doubleValue());
    }

    public  static double cube_root(BigDecimal num1)
    {
        return (double) Math.cbrt(num1.doubleValue());
    }

    public  static double super_squares(BigDecimal num1)
    {
        return (double) Math.pow(num1.doubleValue(), 2);
    }


    public  static double super_cubes(BigDecimal num1)
    {
        return (double) Math.pow(num1.doubleValue(), 3);
    }


    //
    private void setNum1(String oper) {
        System.out.println("MENSAJE:"+str_show.toString());
//        System.out.println("OPERADOR: "+ oper);
//        System.out.println("1: "+first_number);
//        System.out.println("2: "+two_number);
//        System.out.println("Flag 1: "+flag_num1);
//        System.out.println("Flag 2: "+flag_num2);


        if (operator != null && !str_show.toString().equals("") && flag_num1) {
            calculate();
            System.out.println("PASO: 1");
        }
        operator = oper;
        if (!(str_show.toString() == "") && !str_show.toString().equals("-")) {
            first_number = new BigDecimal(str_show.toString());
            showInTextView(str_show.toString());
            str_show = new StringBuffer("");
            str_result = null;
            flag_num1 = true;
            flag_minus = false;
            System.out.println("PASO: 2");
        } else if (str_result != null) {
            first_number = new BigDecimal(str_result);
            showInTextView(str_result);
            str_result = null;
            flag_num1 = true;
            flag_minus = false;
            System.out.println("PASO: 3");
        }
        flag_dot = true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        final String resultText = savedInstanceState.getString(SAVED_INSTANCE_STATE_KEY_RESULT, "");
        final Double firstNumber = savedInstanceState.getDouble(SAVED_INSTANCE_STATE_KEY_FIRST_NUMBER, 0);
        final String operatorText = savedInstanceState.getString(SAVED_INSTANCE_STATE_KEY_OPERATOR, "");
        editText_display.setText(resultText);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(SAVED_INSTANCE_STATE_KEY_RESULT, str_result);
        outState.putDouble(SAVED_INSTANCE_STATE_KEY_FIRST_NUMBER, first_number.doubleValue());
        outState.putString(SAVED_INSTANCE_STATE_KEY_OPERATOR, operator);
        super.onSaveInstanceState(outState);
    }

}
