package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //此处声明变量，可以不先赋值(某些方法在这里面没有）
    private static List<User> data = new ArrayList<>();


    static {

        data.add(new User(123,"aaa","bbb"));


    }

//    //根据结果显示不同的提示
//    private void showToast(boolean isRes){
//        if(isRes){
//            Toast.makeText(MainActivity.this,"恭喜答对了",Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(MainActivity.this,"答错了，好好想想",Toast.LENGTH_SHORT).show();
//        }
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
            @Override//所以控件的父类
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChouJiangActivity.class);



        if(editText2.getText().toString().equals(data.get(0).getUsername())&&editText.getText().toString().equals(data.get(0).getPassword())){

             startActivity(intent);

        }else{

             Toast.makeText(MainActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
             //警告框不一致
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
