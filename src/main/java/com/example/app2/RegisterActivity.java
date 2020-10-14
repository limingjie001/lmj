package com.example.app2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {


    private static List<User> data = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText username=findViewById(R.id.editText);
        EditText tel=findViewById(R.id.editText2);
        EditText password=findViewById(R.id.editText4);
        Button button2=findViewById(R.id.button2);

        button2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                

            }
        });



    }
}