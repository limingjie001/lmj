package com.test.proxy_jdk;

public class HuGe implements Star{
    @Override
    public void sing(String sing) {
        System.out.println("胡歌唱歌"+sing);
    }

    @Override
    public String act(String act) {
        return "胡歌出演电视剧"+act;
    }
}
