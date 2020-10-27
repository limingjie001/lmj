package com.example.app2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class RegisterActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText username = findViewById(R.id.editText);
        final EditText tel = findViewById(R.id.editText2);
        final EditText password = findViewById(R.id.editText4);
        final EditText password2=findViewById(R.id.editText3);
        Button button2 = findViewById(R.id.button2);//注册



//      登录
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tel1 = Integer.valueOf(tel.getText().toString());
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();//密码
                String password22 = password2.getText().toString() ;//确认密码


                Toast.makeText(RegisterActivity.this,"注册成功，请登录",Toast.LENGTH_SHORT).show();

                if(password1.equals(password22)){


                    //        登录（文件写入数据）
                    SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username",username1);
                    editor.putString("password",password1);
                    editor.putInt("tel",tel1);
                    editor.commit();

                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);




                    intent.setClass(RegisterActivity.this,MainActivity.class);

                    startActivity(intent);

                }else{

                    Toast.makeText(RegisterActivity.this,"两次密码输入不一致",Toast.LENGTH_SHORT).show();
                    //警告框不一致
                }


            }
        });


    }
}