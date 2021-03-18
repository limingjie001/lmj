package com.test.proxy_jdk;

import org.junit.jupiter.api.Test;

public class ProxyTest {
    @Test
    public void Test1() {
        HuGeProxy1 huGeProxy1=new HuGeProxy1();
        huGeProxy1.setHuGe(new HuGe());
        Star proxy = huGeProxy1.getProxy();
    proxy.sing("aaaa");
    }

    @Test
    public void Test2(){
        HuGeProxy2 huGeProxy2= new HuGeProxy2();

        huGeProxy2.setHuGe(new HuGe());
        Star proxy = huGeProxy2.getProxy();
        String act1 = proxy.act("aaadsx");
        System.out.println(act1);
    }


}
