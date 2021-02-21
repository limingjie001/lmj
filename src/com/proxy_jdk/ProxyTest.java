package com.proxy_jdk;


import org.junit.Test;

public class ProxyTest {
    //测试代理类1
    @Test
    public void testHuGeProxy1(){

        HuGeProxy1 proxy = new HuGeProxy1();//找到胡歌的助理
        Star hg = proxy.getProcxy();//助理和胡歌洽谈
        hg.sing("《逍遥叹》");//(胡歌答应后)唱歌
        String actResult = hg.act("《琅琊榜》");//(胡歌答应后)演习
        System.out.println("演出结果：" + actResult);
    }
    //测试代理类1
    @Test
    public void testHuGeProxy2(){

        HuGeProxy2 proxy = new HuGeProxy2();
        Star hg = proxy.getProcxy();
        hg.sing("《逍遥叹》");
        String actResult = hg.act("《琅琊榜》");
        System.out.println("演出结果：" + actResult);
    }
//    revert测试
    //版本2
    //这是版本2的内容
    //看一下“版本3”这几个字在不在
    //测试结果，只对版本2有所更改，不影响版本3.
    //如果使用reset，版本2后面的版本就都没有了
}