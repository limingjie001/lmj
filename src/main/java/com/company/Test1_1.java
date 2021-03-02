package com.company;

import static java.lang.Math.log;


public class Test1_1 {
    public static void main(String[] args) {
        float y_0 = (float) (log(6.0) - log(5.0)), y_1;
        int n = 1;
        System.out.printf("y[0]=%-20f", y_0);

        while (true) {
            y_1 = (float)((1.0 / n) - (5 * y_0));
            System.out.printf("y[%d]=%-20f", n, y_1);
            if (n >= 20) break;
            y_0 = y_1;
            n++;
            if (n % 3 == 0)
                System.out.print("\n");
        }


    }

}
