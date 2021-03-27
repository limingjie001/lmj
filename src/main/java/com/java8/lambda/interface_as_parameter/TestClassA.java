package com.java8.lambda.interface_as_parameter;

public class TestClassA {
    public interface SysMsgCallBack{
        public void call();
    };
    public void sysMsg(String msg,SysMsgCallBack callBack){
        System.out.println("msg:\t"+msg);
        callBack.call();
    }
}