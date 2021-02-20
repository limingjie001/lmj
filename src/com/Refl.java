package com;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Refl {

    public static void main(String[] args) {


            Class<?> test = null;

            try {
                test = Class.forName("com.mystery.refl.Person");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // 取得本类的全部属性
            Field[] field = test.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                // 权限修饰符
                int mo = field[i].getModifiers();
                String priv = Modifier.toString(mo);
                // 属性类型
                Class<?> type = field[i].getType();
//                System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");

                System.out.print(priv+" ");

                System.out.print( type.getName()+" ");

                System.out.print( field[i].getName()+"\n");
            }



    }


}