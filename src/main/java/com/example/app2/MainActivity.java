package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private static List<User> data = new ArrayList<>();
//
//
//    static {
//
//        data.add(new User(123,"aaaaaa","bbbbbb"));
//
//
//
//    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = findViewById(R.id.button1);//登录
        Button button2 = findViewById(R.id.button2);//注册
        final EditText editText2=findViewById(R.id.editText2);//用户名
        final EditText editText=findViewById(R.id.editText);//密码




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChouJiangActivity.class);


                String username1 = editText2.getText().toString();//输入的数据
//                String username2 = data.get(0).getUsername();//正确的用户名
                String password1 = editText.getText().toString();//输入的密码
//                String password2 = data.get(0).getPassword();//正确的密码


                //获取SharedPreferences对象
                SharedPreferences sharedPreferences = getSharedPreferences("test",MODE_PRIVATE);
                //获取值
                String username3 = sharedPreferences.getString("username","");
//                读取文件获取正确的登录数据
                String password3 = sharedPreferences.getString("password","");
//                判断用户名或者密码正确的方法


                //用户名密码是否为空
                if (username1.equals("") && password1.equals("")) {

                    Toast.makeText(MainActivity.this, "用户名或密码不可为空", Toast.LENGTH_SHORT).show();
                    //警告框不一致
                } else {

                    //密码长度是否小于6位
                    if (password1.length() < 6) {

                        Toast.makeText(MainActivity.this, "密码不可小于6位", Toast.LENGTH_SHORT).show();
                    } else {


                        //用户名密码是否正确
                        if (username1.equals(username3) && password1.equals(password3)) {

                            intent.putExtra("username", username1);

                            startActivity(intent);

                        } else {

                            Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                            //警告框不一致
                        }

                    }


                }


            }
        });




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });



    }
}
