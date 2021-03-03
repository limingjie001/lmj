package com.proxy_Cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor{
    //要代理的原始对象
    private Object object;

    //1-创建代理对象
    public Object createProcy(Object target){
        this.object = target;
        //1-Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展
        Enhancer enhancer=new Enhancer();

        //2-将被代理类HuGe设置成父类
        enhancer.setSuperclass(this.object.getClass());

        //3-设置拦截器
        enhancer.setCallback(this);

        //4-动态生成一个代理类
        Object objProxy = enhancer.create();

        return objProxy;

    }

    //2-实现MethodInterceptor的intercept方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before: " + method);
        //调用proxy.invoke()方法，会报java.lang.StackOverflowError错误，原因是invoke()内部会一直被反复调用
        //Object object = proxy.invoke(obj, args);
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("after: " + method);
        return object;
    }
}