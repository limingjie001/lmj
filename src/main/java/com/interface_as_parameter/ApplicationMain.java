package com.interface_as_parameter;

public class ApplicationMain {
    public static void main(String[] args) {
        TestClassA testClassA=new TestClassA();
        testClassA.sysMsg("这是输出的信息", new TestClassA.SysMsgCallBack() {
            @Override
            public void call() {
                System.out.println("SysMsgCallBack执行");
            }
        });
    }
}
