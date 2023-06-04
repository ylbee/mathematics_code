package cn.yl.task8;
/**
 * Task 8
 * Use the Secant method to find the root of the function
 * 𝑓(𝑥) = 3𝑥 + sin 𝑥 - 𝑒𝑥
 * to 5 decimal places. Use 𝑥0 = 0 and 𝑥1 = 1
 * @author : Yang Li
 * @version : v1.0
 * @createTime : 2023/6/2 14:00
 */

class FindRootBySecant {
    // Driver code
    public static void main(String[] args) {
        // initializing the values
        float x1 = 0, x2 = 1, E = 0.00001f;
        secant(x1, x2, E);
    }
    // returns 𝑓(𝑥) = 3𝑥 + sin 𝑥 - 𝑒𝑥
    static float f(float x) {
        // we are taking equation
        float f = (float) (3*x + Math.sin(x) - Math.exp(x));
        return f;
    }
    // secant method
    static void secant(float x1, float x2, float E) {
        float n = 0, xm, x0, c;
        if (f(x1) * f(x2) < 0) {
            do {
                // calculate the intermediate value
                x0 = (x1 * f(x2) - x2 * f(x1)) / (f(x2) - f(x1));
                // check if x0 is root of equation or not
                c = f(x1) * f(x0);
                // update the value of interval
                x1 = x2;
                x2 = x0;
                // update number of iteration
                n++;
                // if x0 is the root of equation then break the loop
                if (c == 0)
                    break;
                xm = (x1 * f(x2) - x2 * f(x1)) / (f(x2) - f(x1));
                // repeat the loop until the convergence
            } while (Math.abs(xm - x0) >= E);
            System.out.printf("The value of root is : %.5f", x0);
            System.out.println("\nNo. of iterations = " + n);
        } else
            System.out.print("Can not find a root in the given interval");
    }



}