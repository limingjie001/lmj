package com.multi_threading;

/***
 * 描述：甲乙同时往银行存钱，存够3000
 *
 *
 * */

//账户
class Account{
    private double balance;//余额
    //构造器
    public Account(double balance) {
        this.balance = balance;
    }
    //存钱方法
    public synchronized void deposit(double amt){
        if(amt>0){
            balance +=amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为："+balance);
        }
    }
}

//两个顾客线程
class Customer extends Thread{
    private Account acct;

    public Customer(Account acct){
        this.acct = acct;
    }



    @Override
    public void run() {
        for (int i = 0;i<3;i++){
            acct.deposit(1000);
        }
    }
}

//主方法，之中new同一个账户，甲乙两个存钱线程。
public class AccountTest {

    public static void main(String[] args){
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }

}