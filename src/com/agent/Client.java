package com.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 剧组类,主方法
 */
public class Client {
    public static void main(String[] args) {
        final Actor actor = new Actor();
        /**
         * 剧组找演员，通过经纪公司，它就是代理
         * 涉及的类：Proxy
         * 创建代理对象的方法：newProxyInstance()
         * 该方法的参数：
         *      ClassLoader:；类加载器。和被代理对象使用相同的类加载器
         *      Class[]:字节码数组。被代理类实现的接口，要求代理对象和被代理对象具有相同的行为
         *      InvocationHandler:用于我们提供增强代码的接口。一般会写一个该接口的实现类。
         *                        实现类可以是匿名内部类。它的含义就是如何代理。这里的代码只能是谁用谁提供
         */
        IActor proxyActor = (IActor) Proxy.newProxyInstance(actor.getClass().getClassLoader(),
                actor.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何方法都会经过该方法，该方法有拦截的功能
                     * Object proxy：代理对象的引用。不一定每次都会有
                     * Method method：当前执行的方法
                     * Object[] args：当前执行方法所需的参数
                     * @return 当前执行方法的返回值
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object ret=null;
                        //1.取出执行方法中的参数
                        Float money = (Float) args[0];
                        //2.判断当前执行的什么方法
                        if ("basicAct".equals(method.getName())){
                            if (money>10000)
                                ret = method.invoke(actor,money);
                        }
                        if ("advancedAct".equals(method.getName())){
                            if (money>50000)
                                ret = method.invoke(actor,money);
                        }
                        return ret;
                    }
                });
        proxyActor.basicAct(20000);
    }
}

