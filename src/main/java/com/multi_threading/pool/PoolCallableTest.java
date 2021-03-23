package com.multi_threading.pool;

import java.util.concurrent.*;
/*
    Callable接口配合线程池使用
 */
public class PoolCallableTest implements Callable {



    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return true;
    }


    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(5);

        PoolCallableTest t1 = new PoolCallableTest();
        PoolCallableTest t2 = new PoolCallableTest();

        Future<Boolean> future=service.submit(t1);
        Future<Boolean> future2=service.submit(t2);

        try {
            Boolean aBoolean = future.get();
            System.out.println(aBoolean);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();

    }


}
