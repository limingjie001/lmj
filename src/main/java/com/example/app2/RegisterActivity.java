package com.example.app2;

import android.annotation.SuppressLint;
import android.content.Intent;
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


    private static List<User> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText username = findViewById(R.id.editText);
        final EditText tel = findViewById(R.id.editText2);
        final EditText password = findViewById(R.id.editText4);
        final EditText password2=findViewById(R.id.editText3);
        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tel1 = Integer.valueOf(tel.getText().toString());
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();//密码
                String password22 = password2.getText().toString() ;//确认密码

                data.add(new User(tel1, username1, password1));
                Log.i(username1, " username1");
                Log.i(password1, " password1");

                Toast.makeText(RegisterActivity.this,"注册成功，请登录",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                if(password1.equals(password22)){

                    startActivity(intent);

                }else{

                    Toast.makeText(RegisterActivity.this,"两次密码输入不一致",Toast.LENGTH_SHORT).show();
                    //警告框不一致
                }


            }
        });


    }
}