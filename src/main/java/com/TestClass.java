package com;



class Polygon {
    public void display() {
        System.out.println("在 Polygon 类内部");
    }
}

class AnonymousDemo {
    public void createClass() {

        // 创建的匿名类继承了 Polygon 类
        Polygon p1 = new Polygon() {
            public void display() {
                System.out.println("在匿名类内部。");
            }
        };
        p1.display();
    }
}

class TestClass {
    public static void main(String[] args) {
        AnonymousDemo an = new AnonymousDemo();
        an.createClass();
    }
}

