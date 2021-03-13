package com.list;

import java.util.*;

public class Student extends Thread implements Comparable {
    private int age;
    private String name;
    private String tel;
    private int height;


    public Student(String name, int age, String tel, int height) {
        this.age = age;
        this.name = name;
        this.tel = tel;
        this.height = height;
    }

    public static void main(String args[]) throws InterruptedException {
        Student stu1 = new Student("张三", 21, "156482", 172);
        Student stu2 = new Student("李四", 18, "561618", 168);
        Student stu3 = new Student("王五", 19, "841681", 170);
        Student stu4 = new Student("赵七", 20, "562595", 180);

        List<Student> list = new ArrayList<Student>();
        //乱序插入
        list.add(stu3);
        list.add(stu1);
        list.add(stu4);
        list.add(stu2);
        //也可以这样写
        list.add(new Student("李四", 18, "561618", 168));

        System.out.println("-----------排序前----------");
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }



        /*
         * 使用Collections的sort方法让集合排序，使用其方法必须要重写
         * Comparable接口的compareTo()方法
         * */
        Collections.sort(list);
        System.out.println("-----------按照年龄排序后----------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    //重写compareTo方法，用age来比较。也可以用别的来比较
    @Override
    public int compareTo(Object o) {
        //使用当前对象的年龄和其他对象的年龄比较，如果<0返回负数，>0返回正数，=0返回0
        int z = this.age - ((Student) o).getAge();
        if (z < 0)
            return -1;  // 返回其他负数也行
        else if (z == 0)
            return 0;
        else
            return 1;  //返回其他正数也行
    }

    //重写toString，便于输出
    @Override
    public String toString() {
        return name + "," + age + "," + tel + "," + height;
    }

    public int getAge() {
        return age;
    }


}
