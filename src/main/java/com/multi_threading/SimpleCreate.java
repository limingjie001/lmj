package com.multi_threading;

public class SimpleCreate {

    public static void test1() {
        Thread t = new Thread(() -> {
            for(int i=0;i<30;i++){
                System.out.println(Thread.currentThread().getName()+"运行, i="+i);  //取得当前线程的名称
            }
        }, "t1");
        t.start();

    }


    public static void test2() {
        Thread thread = new Thread() {

            public void run() {
                for(int i=0;i<30;i++){
                    System.out.println(Thread.currentThread().getName()+"运行, i="+i);  //取得当前线程的名称
                }
            }
        };
        thread.setName("t2");
        thread.start();

    }

    public static void main(String[] args) {
        SimpleCreate.test1();
        SimpleCreate.test2();
    }
}

