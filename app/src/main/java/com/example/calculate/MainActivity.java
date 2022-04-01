package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculate.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvResult;
    private ActivityMainBinding binding;
    private String firstNum = "";
    private String operator = "";
    private String secondNum = "";
    private String result = "";
    private String showText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }
    private void initView(){
        tvResult=binding.tvResult;
        binding.btnCancel.setOnClickListener(this);
        binding.btnDivide.setOnClickListener(this);
        binding.btnMultiply.setOnClickListener(this);
        binding.btnClear.setOnClickListener(this);
        binding.btnSeven.setOnClickListener(this);
        binding.btnEight.setOnClickListener(this);
        binding.btnNight.setOnClickListener(this);
        binding.btnAdd.setOnClickListener(this);
        binding.btnFour.setOnClickListener(this);
        binding.btnFive.setOnClickListener(this);
        binding.btnSix.setOnClickListener(this);
        binding.btnSubtract.setOnClickListener(this);
        binding.btnOne.setOnClickListener(this);
        binding.btnTwo.setOnClickListener(this);
        binding.btnThree.setOnClickListener(this);
        binding.btnSqrt.setOnClickListener(this);
        binding.btnFraction.setOnClickListener(this);
        binding.btnZero.setOnClickListener(this);
        binding.btnDot.setOnClickListener(this);
        binding.btnResult.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String inputText;
        inputText =((TextView) v).getText().toString();
        switch (v.getId()){
            //点击清除按钮
            case R.id.btn_clear:
                clear();
                break;
            //点击取消按钮
            case R.id.btn_cancel:
                break;
            //点击加减乘除按钮
            case R.id.btn_add:
            case R.id.btn_subtract:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                operator = inputText;
                refreshText(showText + operator);
                break;
            //点击等号
            case R.id.btn_result:
                double calculateResult = calculateFour();
                refreshOperate(String.valueOf(calculateResult));
                refreshText(showText + "=" + result);
                break;
            //点击根号
            case R.id.btn_sqrt:
                double sqrtResult = Math.sqrt(Double.parseDouble(firstNum));
                refreshOperate(String.valueOf(sqrtResult));
                refreshText(showText + "√=" + result);
                break;
            //点击分数
            case R.id.btn_fraction:
                double fraction = 1.0 / Double.parseDouble(firstNum);
                refreshOperate(String.valueOf(fraction));
                refreshText(showText + "/=" + result);
                break;
            default:
                if(result.length() > 0 && operator.equals("")){
                    clear();
                }
                if(operator.equals("")){
                    firstNum = firstNum + inputText;
                }else {
                    secondNum = secondNum + inputText;
                }
                if(showText.equals("0") && !inputText.equals(".")){
                    refreshText(inputText);
                }else {
                    refreshText(showText + inputText);
                }
                break;
        }
    }

    private double calculateFour() {
        switch (operator){
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case "*":
                return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            default:
                return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
    }

    private void clear() {
        refreshOperate("");
        refreshText("");
    }

    private void refreshOperate(String newResult){
        result = newResult;
        firstNum = result;
        secondNum = " ";
        operator = " ";

    }
    private void refreshText(String text){
        showText = text;
        tvResult.setText(showText);
    }
}