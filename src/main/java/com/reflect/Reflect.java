package com.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

public class Reflect {
    @Test
    public void test(){
        Class personCls=Person.class;
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.print(fields);
            
        }
    }
}
