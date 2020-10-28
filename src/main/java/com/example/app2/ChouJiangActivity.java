package com.example.app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChouJiangActivity extends AppCompatActivity {

//public class ChouJiangActivity extends AppCompatActivity {

    int index = 1;
    int jpMax = 6;
    ;
    int numInt;

    int[] jp = {R.drawable.jp1, R.drawable.jp2, R.drawable.jp3, R.drawable.jp4, R.drawable.jp5, R.drawable.jp6};


    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //销毁前存值
        outState.putInt("index", index);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choujiang);

    //  public View onCreateView(LayoutInflater inflater, ViewGroup container,
        //                             Bundle savedInstanceState) {



        //如果有暂存值，取出
        if (savedInstanceState != null) {
            numInt = jpMax - savedInstanceState.getInt("index");
        }


        final Button button1 = findViewById(R.id.button1);//抽奖
        final Button button2 = findViewById(R.id.button2);//领奖
        Button button3 = findViewById(R.id.button3);//浏览
        Intent intent = getIntent();
        String user = (String) intent.getSerializableExtra("username");
        Toast.makeText(ChouJiangActivity.this, "欢迎您" + user + "登录", Toast.LENGTH_SHORT).show();

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChouJiangActivity.this, JiangPinActivity.class);
                startActivity(intent);
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            ImageView imageView = (ImageView) findViewById(R.id.toJP);//获取图片
            TextView num = findViewById(R.id.textView9);//剩余抽奖次数

            @Override
            public void onClick(View v) {
                numInt = Integer.parseInt(String.valueOf(num.getText()));//整型数据

//            imageView.setImageResource(R.drawable.jp2);
                //设置图片抽奖
//                Log.w("numInt", String.valueOf(numInt));
                if (index < jpMax) {
                    imageView.setImageResource(jp[index]);
                    index++;
                }


                if (index == jpMax) {
                    button1.setEnabled(false);
                    numInt--;
                }
                numInt--;
                //  Log.i("numInt",String.valueOf(numInt));
                num.setText(String.valueOf(numInt));//抽奖次数，送回数据
            }
        });


        //弹窗显示奖品
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChouJiangActivity.this);
                builder.setTitle("恭喜你中奖了");

                builder.setPositiveButton("确认领奖", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ChouJiangActivity.this, "奖品已领取", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ChouJiangActivity.this, JiangPinActivity.class);
                        startActivity(intent);
                    }


                });
                builder.setNegativeButton("不要奖品", null);
                builder.show();

            }
        });


    //  return inflater.inflate(R.layout.choujiang, container, false);

    }
}