package com.tarun.calculatorop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtExpression, txtResult;
    String expression, result;
    Expression expressionBuilder;
    double doubleOutput;
    long longOutput;
    boolean outputIsDouble, evaluated;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        Button btnNine = findViewById(R.id.btn_nine);
        Button btnEight = findViewById(R.id.btn_eight);
        Button btnSeven = findViewById(R.id.btn_seven);
        Button btnSix = findViewById(R.id.btn_six);
        Button btnFive = findViewById(R.id.btn_five);
        Button btnFour = findViewById(R.id.btn_four);
        Button btnThree = findViewById(R.id.btn_three);
        Button btnTwo = findViewById(R.id.btn_two);
        Button btnOne = findViewById(R.id.btn_one);
        Button btnZero = findViewById(R.id.btn_zero);
        Button btnDoubleZero = findViewById(R.id.btn_double_zero);
        Button btnDot = findViewById(R.id.btn_dot);
        Button btnMod = findViewById(R.id.btn_mod);
        Button btnDivide = findViewById(R.id.btn_divide);
        Button btnMultiply = findViewById(R.id.btn_multiply);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnEqualsTo = findViewById(R.id.btn_equals_to);
        Button btnDel = findViewById(R.id.btn_del);
        Button btnClear = findViewById(R.id.btn_clear);

        txtExpression = findViewById(R.id.txt_expression);
        txtResult = findViewById(R.id.txt_result);

        btnNine.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnDoubleZero.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnEqualsTo.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (expression != null && expression.length() >= 10) {
            txtExpression.setTextSize(28);
        } else {
            txtExpression.setTextSize(50);
        }

        switch (v.getId()) {

            case R.id.btn_nine:
                expression = txtExpression.getText() + "9";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_eight:
                expression = txtExpression.getText() + "8";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_seven:
                expression = txtExpression.getText() + "7";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_six:
                expression = txtExpression.getText() + "6";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_five:
                expression = txtExpression.getText() + "5";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_four:
                expression = txtExpression.getText() + "4";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_three:
                expression = txtExpression.getText() + "3";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_two:
                expression = txtExpression.getText() + "2";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_one:
                expression = txtExpression.getText() + "1";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_zero:
                expression = txtExpression.getText() + "0";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_double_zero:
                expression = txtExpression.getText() + "00";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_dot:
                expression = txtExpression.getText() + ".";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_add:
                expression = txtExpression.getText() + "+";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_minus:
                expression = txtExpression.getText() + "-";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_divide:
                expression = txtExpression.getText() + "÷";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_multiply:
                expression = txtExpression.getText() + "×";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_mod:
                expression = txtExpression.getText() + "%";
                txtExpression.setText(expression);
                evaluateExpression();
                break;

            case R.id.btn_del:
                if (expression.isEmpty())
                    break;
                else {
                    expression = expression.substring(0, expression.length() - 1);
                    txtExpression.setText(expression);
                    evaluated = false;
                    txtResult.setText("");
                }
                break;

            case R.id.btn_clear:
                txtExpression.setText("");
                txtResult.setText("");
                expression = "";
                doubleOutput = 0;
                longOutput = 0;
                break;

            case R.id.btn_equals_to:
                try {
                    if (expression.isEmpty() || doubleOutput == 0 || longOutput == 0) {
                        break;
                    } else {
                        if (evaluated) {
                            if (outputIsDouble) {
                                expression = String.valueOf(doubleOutput);
                                txtExpression.setText(String.valueOf(doubleOutput));
                            } else {
                                expression = String.valueOf(longOutput);
                                txtExpression.setText(String.valueOf(longOutput));
                            }
                            txtResult.setText("");
                        } else
                            evaluateExpression();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    private void evaluateExpression() {

        if (expression.contains("+") || expression.contains("-") || expression.contains("×") || expression.contains("÷") || expression.contains("%")) {
            result = expression;
            result = result.replace('×', '*');
            result = result.replace('÷', '/');

            try {
                expressionBuilder = new ExpressionBuilder(result).build();
                doubleOutput = expressionBuilder.evaluate();
                evaluated = true;
                longOutput = (long) doubleOutput;
                if (doubleOutput == longOutput) {
                    outputIsDouble = false;
                    result = String.valueOf(longOutput);
                    txtResult.setText(result);
                } else {
                    result = String.valueOf(doubleOutput);
                    txtResult.setText(result);
                    outputIsDouble = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            evaluated = false;
    }
}
