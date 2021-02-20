package com.proxy_Cglib;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;

public class cglibMethodInterceptorTest {

    @Test
    public void testProcyFactory(){
        //1-实例化需要被代理的类
        HuGe huGe = new HuGe();
        //2-实例化代理工厂
        ProxyFactory cglibProxy = new ProxyFactory();
        //3-动态生成一个代理类，并从Object强制转型成父类型HuGe
        HuGe hg =(HuGe)cglibProxy.createProcy(huGe);

        //4-执行动态代理类的方法
        hg.sing("逍遥叹");
        hg.act("琅琊榜");

    }

}