package com.agent;

/**
 * 演员类
 */
public class Actor implements IActor{
    public void basicAct(float money){
        System.out.println("拿到"+money+"钱，开始初级表演");
    }
    public void advancedAct(float money){
        System.out.println("拿到"+money+"钱，开始高级表演");
    }
}
