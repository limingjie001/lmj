package com.company;

public class Test02 {
    public static void main(String[] args) {

        float y_0= (float) ((1/105.0+1/126.0)/2),y_1;
        int n=20;
         System.out.printf("y[20]=%-20f",y_0);
        while(true) {
            y_1 = (float) (1 / (5.0 * n) - y_0 / 5.0);
            System.out.printf("y[%d]=%-20f", n - 1, y_1);
            if (n <= 1) break;
            y_0 = y_1;
            n--;
            if (n % 3 == 0)
                System.out.printf("\n");

        }

    }
}
