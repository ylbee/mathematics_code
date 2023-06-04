package cn.yl.task4;

/**
 * auther  YangLi
 * Task 4 code
 */
public class Transpose {

    public static void main(String[] args) {
        double[][] matrix = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        printMatrix(matrixTranspose(matrix));

    }

    /**
     * matrix transpose
     * @param A input matrix
     * @return Returns the transposed matrix
     * @throws Exception
     */
    public static double[][] matrixTranspose(double[][] A)
    {
        double[][] AT = new double[A[0].length][A.length];
        for (int i = 0; i < AT.length; i++)
            for (int j = 0; j < AT[i].length; j++)
                AT[i][j] = A[j][i];
        return AT;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
