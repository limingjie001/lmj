package com.company;

import java.util.Scanner;


public class Test2_2 {
    static float f(float x) {
        float f;
        f = x * x * x - x - 1;
        return (f);
    }

    static float df(float x) {

        float df;
        df = 3 * x * x - 1;
        return (df);
    }

    public static void main(String[] args) {


        float x0, x1, d, eps;
        int k = 0;
        System.out.print("Please input x0:");

        Scanner input1 = new Scanner(System.in);
        x0 = input1.nextFloat();


        System.out.print("Please input eps:");

        Scanner input2 = new Scanner(System.in);
        eps = input2.nextFloat();
        System.out.print("k, xk\n");
        System.out.print("--------------------------\n");
        System.out.printf("%d, %f\n", k, x0);
        do {
            d = -f(x0) / df(x0);
            x1 = x0 + d;
            k++;
            x0 = x1;
            System.out.printf("%d,%f\n", k, x0);
        }
        while (Math.abs(d) > eps);
        System.out.print("-------------------------\n");
        System.out.printf("The root of the equation is x=%f k=%d\n", x1, k);


    }
}
