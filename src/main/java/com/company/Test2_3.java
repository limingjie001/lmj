package com.company;

import java.util.Scanner;

public class Test2_3 {


    private static final int KMAX = 50;

    static float g(float x) {
        float g;
        g = x * x * x - 1;
        return g;
    }

    static void aitken(float x, float eps) {
        float x0, y, z;
        int k = 0;
        do {
            x0 = x;
            y = g(x0);
            z = g(y);
            x = z - ((z - y) * (z - y)) / (z - 2 * y + x0);
            k++;
            System.out.printf("%d, %f\n", k, x);
        }
        while ((Math.abs(x - x0) > eps) || (k == KMAX));
        if (k == KMAX)
            System.out.printf("Iteration fault!\n");
        else
            System.out.printf("--------------\n");
        System.out.printf("The root of the equation is x=%f k=%d\n", x, k);
    }

    public static void main(String[] args) {


        float x, eps;
        System.out.printf("Please input x:");
        Scanner input1 = new Scanner(System.in);
        x = input1.nextFloat();
        System.out.printf("Please input eps:");
        Scanner input2 = new Scanner(System.in);
        eps = input1.nextFloat();
        System.out.printf("k, xk\n");
        System.out.printf("----------------------\n");

        System.out.printf("%d, %f\n", 0, x);
        aitken(x, eps);


    }
}
