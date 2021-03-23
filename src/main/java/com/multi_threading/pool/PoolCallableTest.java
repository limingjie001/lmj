package com.multi_threading.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
    Callable接口配合线程池使用
 */
//实现callable接口
public class PoolCallableTest implements Callable {

    private int i;


    public PoolCallableTest(int i) {
        this.i = i;

    }

    //重写call方法
    @Override
    public String call() throws Exception {
        for (int i = 999999; i > 0; i--) ;
        return "Callable执行,id为" + i;
    }

    public static void main(String[] args) {

        //创建执行服务
        ExecutorService executorService = Executors.newCachedThreadPool();


        List<Future<String>> arrayList = new ArrayList<>();
        //提交执行
        for (int i = 0; i < 10; i++) {
            //new创建目标对象
            Future<String> future = executorService.submit((new PoolCallableTest(i)));
            arrayList.add(future);
        }


//获取值需要抛异常
        for (Future<String> stringFuture : arrayList) {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
//关闭服务
        executorService.shutdown();
    }


}





