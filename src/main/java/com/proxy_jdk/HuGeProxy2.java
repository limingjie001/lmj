package com.proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//胡歌代理类2
//实现InvocationHandler接口,实现invoke方法
public class HuGeProxy2 implements InvocationHandler{

    private Star hg = new HuGe();

    public Star getProcxy(){
        return (Star)Proxy.newProxyInstance(
                getClass().getClassLoader(),
                hg.getClass().getInterfaces(),
                this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().equals("sing")){
            System.out.println("我是胡歌代理2，找胡歌唱歌找我");
            return method.invoke(hg, args);
        }
        if(method.getName().equals("act")){
            System.out.println("我是胡歌代理2，找胡歌演电视剧找我");
            return method.invoke(hg, args);
        }

        return null;
    }



}