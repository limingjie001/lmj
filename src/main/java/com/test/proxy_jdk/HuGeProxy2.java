package com.test.proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HuGeProxy2 implements InvocationHandler {

    private HuGe huGe;

    public void setHuGe(HuGe huGe) {
        this.huGe = huGe;
    }

    public Star getProxy(){
        return (Star) Proxy.newProxyInstance(this.getClass().getClassLoader(), huGe.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(huGe,args);
    }
}
