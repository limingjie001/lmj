package com.example.app2.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.app2.R;
import com.example.app2.login;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.String.valueOf;

//public class RegisterActivity extends AppCompatActivity {
public class RegisterFragment extends Fragment {


    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.register);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.register, container, false);


        final EditText username = view.findViewById(R.id.editText);
        final EditText tel = view.findViewById(R.id.editText2);
        final EditText password = view.findViewById(R.id.editText4);
        final EditText password2 = view.findViewById(R.id.editText3);
        Button button2 = view.findViewById(R.id.button2);//注册


//      登录
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tel1 = Integer.valueOf(tel.getText().toString());
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();//密码
                String password22 = password2.getText().toString();//确认密码


                Toast.makeText(getActivity(), "注册成功，请登录", Toast.LENGTH_SHORT).show();

                if (!username1.equals("") && !password1.equals("") && !password22.equals("")) {
                    if (password1.equals(password22)) {


                        //登录（文件写入数据）
                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("test", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username1);
                        editor.putString("password", password1);
                        editor.putInt("tel", tel1);
                        editor.commit();

                        Intent intent = new Intent(getActivity(), login.class);


                        intent.setClass(getActivity(), login.class);

                        startActivity(intent);

                    } else {

                        Toast.makeText(getActivity(), "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                        //警告框不一致
                    }
                } else {

                    Toast.makeText(getActivity(), "请输入完所有的信息再注册", Toast.LENGTH_SHORT).show();
                    //警告框不为空
                }


            }
        });


        return inflater.inflate(R.layout.register, container, false);
    }
}