package com.example.app2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app2.fragment.ChouJiangFragment;
import com.example.app2.fragment.JiangFragment;
import com.example.app2.fragment.RegisterFragment;
import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends AppCompatActivity {
    private TabView tabView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /**
         * 1.获得TabView实例
         * 2.创建TabViewChild集合
         * 3.实例化各个TabViewChild，并添加到集合中
         * 4.将tabViewChild集合装载到tabView中
         * 5.设置特殊的属性(默认位置)
         */
        tabView = findViewById(R.id.tabView);
        List<TabViewChild> tabViewChildList = new ArrayList<>();
        //实例化各个TabViewChild，并添加到集合中
        /**
         * 第一个参数：导航栏上面的某一个tab被点击时候，相应的切换的图片
         * 第二个参数：导航栏上面的tab没有被被点击时候，相应的切换的图片
         * 第三个参数：导航栏上面的某一个tab的文字显示
         * 第四个参数：导航栏上面的某一个tab对应的Fragment对象
         */
        TabViewChild message = new TabViewChild(
                R.drawable.tab03_sel,
                R.drawable.tab03_unsel,
                "抽奖",
                new ChouJiangFragment());
        tabViewChildList.add(message);
        TabViewChild contact = new TabViewChild(
                R.drawable.tab01_sel,
                R.drawable.tab01_unsel,
                "奖品",
                new JiangFragment());
        tabViewChildList.add(contact);
//        TabViewChild appChild = new TabViewChild(
//                R.drawable.tab02_sel,
//                R.drawable.tab02_unsel,
//                "奖品",
//                new AppFragment());
//        tabViewChildList.add(appChild);
        TabViewChild person = new TabViewChild(
                R.drawable.tab05_sel,
                R.drawable.tab05_unsel,
                "注册",
                new RegisterFragment());
        tabViewChildList.add(person);
        //将tabViewChild集合装载到tabView中
        tabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
        //设置默认位置
        //tabView.setTabViewDefaultPosition(0);
//        tabView.setImageViewHeight(dip2px(30));

//        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
//            @Override
//            public void onTabChildClick(int position, ImageView imageView, TextView textView) {
//                Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}