package cn.yl.task8;

/**
 * Task 8
 * Find the positive root of the following equation by the Bisection method
 * let ε = 0.01 and start with the interval [1, 2]
 * 𝑓(𝑥) = 6𝑥^3 + 3𝑥^2 - 16
 * @author : Yang Li
 * @version : v1.0
 * @createTime : 2023/6/2 14:00
 */

class FindRootByBisection {
    static final float EPSILON = (float) 0.01;

    // Driver program to test above function
    public static void main(String[] args)
    {
        // Initial values assumed
        double a =1, b = 2;
        bisection(a, b);
    }
    // 𝑓(𝑥) = 6𝑥^3 + 3𝑥^2 - 16
    static double func(double x) {
        return 6 * Math.pow(x,3) + 3 * Math.pow(x,2) - 16;
    }
    // Prints root of func(x) with error of EPSILON
    static void bisection(double a, double b) {
        if (func(a) * func(b) >= 0) {
            System.out.println("You have not assumed right a and b");
            return;
        }
        double c = a;
        while ((b - a) >= EPSILON) {
            // Find middle point
            c = (a + b) / 2;
            // Check if middle point is root
            if (func(c) == 0.0)
                break;
                // Decide the side to repeat the steps
            else if (func(c) * func(a) < 0)
                b = c;
            else
                a = c;
        }
        //prints value of c upto 4 decimal places
        System.out.printf("The value of root is : %.5f", c);
    }
}