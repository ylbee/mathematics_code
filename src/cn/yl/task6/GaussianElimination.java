package cn.yl.task6;
/**
 * Task 6  The code of GaussianElimination
 * @author : Yang Li
 * @version : v1.0
 * @createTime : 2023/5/17 21:39
 */
public class GaussianElimination {

    // This is the task6 equations
    private static double[][] EQUATIONS = {
        { 3, -1, 1, 12 },  // 3x -  y + z = 12
        { 5,  1, 2,  3 },  // 5x +  y + 2z = 3
        { 1,  1, 2,  3 }   //  x +  y + 2z = 3
    };
    public static void main(String[] args) {
        printEquations(EQUATIONS);

    }
    public static void printEquations(double[][] equations) {
        System.out.printf("This is the task6 equations:\n");
        System.out.printf("  3x -  y + z = 12\n  5x +  y + 2z = 3 \n  x +  y + 2z = 3\n");
        System.out.printf("Transform the system of equations into a matrix:\n");
        print(equations);
        solve(equations);
        System.out.println("reduced row echelon form GaussianElimination:");
        print(equations);
        printSolution(equations);
    }


    public static void solve(double[][] c, int row) {
        int rows = c.length;
        int cols = rows + 1;
        // 1. set c[row][row] equal to 1
        double factor = c[row][row];
        for (int col=0; col<cols; col++)
            c[row][col] /= factor;

        // 2. set c[row][row2] equal to 0
        for (int row2=0; row2<rows; row2++)
            if (row2 != row) {
                factor = -c[row2][row];
                for (int col=0; col<cols; col++)
                    c[row2][col] += factor * c[row][col];
            }
    }

    public static void solve(double[][] c) {
        int rows = c.length;
        for (int row=0; row<rows; row++)
            solve(c,row);
    }

    public static void print(double[][] c) {
        int rows = c.length;
        int cols = rows + 1;
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++)
                System.out.printf("%5.1f ",c[row][col]);
            System.out.println();
        }
        System.out.println();
    }

    public static void printSolution(double[][] c) {
        int rows = c.length, cols = rows + 1;
        char variable = (char)((rows > 3) ? ('z' - (rows-1)) : 'x');
        System.out.println("Solution:\n");
        for (int row=0; row<rows; row++)
            System.out.printf("  %c = %1.1f\n",(char)variable++,c[row][cols-1]);
        System.out.println();
    }


}