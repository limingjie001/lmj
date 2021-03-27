package com.java8.optional;

import org.junit.jupiter.api.Test;
//import org.junit.Test;

import java.util.Optional;

public class Java8Optional {
    public static void main(String args[]) {

        Java8Optional java8Tester = new Java8Optional();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(java8Tester.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }

    @Test
    public void test1() {
        Optional<String> optional = Optional.of("str");
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
    }

    @Test
    public void test2() {
        Optional<String> optional = Optional.of("str2");
        optional.ifPresent(s -> System.out.println(s));
    }


    @Test
    public void test3() {

    }
}