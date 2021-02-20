package com.proxy_static;

public class HelloProxy implements HelloInterface{
    private HelloInterface helloInterface = new Hello();
//private Hello helloInterface = new Hello();
    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello" );
        helloInterface.sayHello();
        System.out.println("After invoke sayHello");
    }
}