package com.swufe.firstapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvTitle;       //��̬�ı���
    private TextView tvResult;
    private EditText editInput;     //�����ı���
    private Button btnC2F;          //���尴ť
    private Button btnF2C;
// add something
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ͨ��finViewById����ʵ�������Ͽؼ���
        tvTitle = (TextView)findViewById(R.id.tv_title);
        tvResult = (TextView)findViewById(R.id.tv_result);
        editInput = (EditText) findViewById(R.id.et_input);
        btnC2F = (Button)findViewById(R.id.celsius_to_fahren);
        btnF2C = (Button)findViewById(R.id.fahren_to_celsius);

        //���ð�ť�������
        btnC2F.setOnClickListener(this);
        btnF2C.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.celsius_to_fahren:
                outputValue(false);
                break;
            case R.id.fahren_to_celsius:
                outputValue(true);
                break;
            default:
        }
    }
    private boolean checkValidInput(){
        if(editInput.getText().length()==0){
            String errorMsg = getResources().getString(R.string.msg_error_input);
            Toast.makeText(this,errorMsg,Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }
    private void outputValue(boolean isF2C){
        if(checkValidInput()){
            float inputValue = Float.parseFloat(editInput.getText().toString());
            if(isF2C){
                String title = getResources().getString(R.string.fahren);
                title = title + String.valueOf(inputValue);
                title = title + getResources().getString(R.string.celsius);
                tvTitle.setText(title);
                tvResult.setText(String.valueOf(getF2C(inputValue)));
            }else{
                String title = getResources().getString(R.string.celsius);
                title = title + String.valueOf(inputValue);
                title = title + getResources().getString(R.string.fahren);
                tvTitle.setText(title);
                tvResult.setText(String.valueOf(getC2F(inputValue)));
            }
        }
    }
    private float getF2C(float f){
        return ((f-32.0f)/1.8f);
    }
    private float getC2F(float c){
        return (c*1.8f)+32.0f;
    }
}
