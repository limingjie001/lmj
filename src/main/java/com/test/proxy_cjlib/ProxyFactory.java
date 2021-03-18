package com.test.proxy_cjlib;

import com.reflect.Person;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private Object object;

    public Object creatProxy(Object target){
        this.object=target;

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(this.object.getClass());

        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        return methodProxy.invokeSuper(o,objects);


    }


}
