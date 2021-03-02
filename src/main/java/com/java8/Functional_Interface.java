package com.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional_Interface {

    @Test
    public void test() {
        happy(10000, new Consumer<Double>() {
            public void accept(Double m) {
                System.out.println("大保健花了：" + m);
            }
        });
    }
    public void happy(double  money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test1() {
        List<Integer> numList = getNumList(10, ()->(int)(Math.random()*100 ));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    //需求：产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<num;i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    @Test
    public void  test2() {
        String trimStr=strHandler("\t\t  你好，world！   ",(str) -> str.trim());
        System.out.println(trimStr);


        String sumString=strHandler("Helloworld!",(str)->str.substring(2, 4));
        System.out.println(sumString);
    }
    //需求：用于处理字符串
    public  String strHandler(String str, Function<String,String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test3() {
        List<String> list= Arrays.asList("Hello","world","hi","o","123");
        List<String> filterStr = filterStr(list, (str)->str.length()>1);
        for (String string : filterStr) {
            System.out.println(string);
        }
    }

    //需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> list2=new ArrayList<>();

        for (String str : list) {
            if(pre.test(str)){
                list2.add(str);
            }
        }

        return list2;
    }
}
