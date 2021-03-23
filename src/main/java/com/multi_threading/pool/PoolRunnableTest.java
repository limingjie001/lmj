package com.multi_threading.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolRunnableTest {
    public static void main(String[] args) {
        //1.创建服务
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //2.执行
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        //3.关闭连接
        executorService.shutdown();


    }


}

