package com.multi_threading;

/**
 * 线程通信的应用：生产者/消费者问题
 *
 * 1.是否是多线程问题？是的，有生产者线程和消费者线程（多线程的创建，四种方式）
 * 2.多线程问题是否存在共享数据？ 存在共享数据----产品（同步方法，同步代码块，lock锁）
 * 3.多线程是否存在线程安全问题？ 存在----都对共享数据产品进行了操作。（三种方法）
 * 4.是否存在线程间的通信，是，如果生产多了到20时，需要通知停止生产（wait）。（线程之间的通信问题，需要wait，notify等）
 *
 * */


class Clerk{

    private int productCount = 0;


    //生产产品
    public synchronized void produceProduct() {

        if(productCount<20) {
            productCount++;

            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            notify();
        }else{
            //当有20个时，等待wait
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if (productCount>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            productCount--;
            notify();
        }else{
            //当0个时等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{//生产者线程

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+";开始生产产品......");

        while(true){
            clerk.produceProduct();
        }
    }
}

class Consumer implements Runnable{//消费者线程

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+":开始消费产品");

        while(true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }

    }
}

public class ProductTest {

    public static void main(String[] args){
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        Thread t1 = new Thread(c1);
        t1.setName("消费者1");

        p1.start();
        t1.start();

    }

}