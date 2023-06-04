package cn.yl.task3;
    public class InverseMatrix {

    public static void main(String[] args) {
        double[][] matrix = {{2, 3, 1}, {3, 3, 1}, {2, 4, 1}};
        printMatrix(matrixInverse(matrix));

    }

    /**
     * Calculation of inverse matrix A^-1 = A * 1/|A|
     * Invertible condition: det(A) is not 0 and A is square matrix
     * @param A Enter square matrix A
     * @return Returns the inverse matrix or null if the matrix is not invertible
     */
    public static double[][] matrixInverse(double[][] A)
    {
        double[][] result = new double[A.length][A[0].length];
        double val = det(A);
        if(val==0){
            System.out.println("The determinant is 0, the matrix is not invertible");
            result = null;
        }
        else {
            for(int i=0; i<A.length; i++) {
                for(int j=0; j<A[0].length; j++) {
                    if((i+j)%2 == 0) {
                        result[i][j] = det(getCofactor(A, i+1, j+1)) /val;
                    }else {
                        result[i][j] = -det(getCofactor(A, i+1, j+1)) /val;
                    }

                }
            }
            result = matrixTranspose(result);
        }
        return result;
    }

    /**
     * matrix transposition
     * @param A Enter the determinant A
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

    /**
     * Evaluate the determinant
     * @param A Enter the determinant A
     * @return Returns the value of the determinant
     */
    public static double det(double[][] A)
    {

        double result = 0;
        if(A.length==2) result = A[0][0]*A[1][1]-A[0][1]*A[1][0];
        else{
            double[] data = new double[A.length];
            for (int i = 0; i < data.length; i++) {
                if(i%2==0)
                    data[i]=A[0][i]*det(getCofactor(A,1,i+1));
                else
                    data[i]=-A[0][i]*det(getCofactor(A,1,i+1));
            }
            for (int i = 0; i < data.length; i++) {
                result+=data[i];
            }
        }
        return result;
    }
    /**
     * Computes cosubformulas in coordinates of determinant (m,n)
     * Note: Both m and n start at 1, not by array index
     * @param A Input matrix 1
     * @param m x-coordinate
     * @param n y-coordinate
     * @return Returns the subformula in coordinates (m,n)
     */
    public static double[][] getCofactor(double[][] A, int m,int n)
    {
        int M= A.length;
        int N = A[0].length;
        double[][] result = new double[M-1][N-1];
        for (int i = 0; i < result.length; i++) {
            if (i<m-1) {
                for (int j = 0; j < result[i].length; j++) {
                    if (j<n-1) {
                        result[i][j] = A[i][j];
                    }
                    else result[i][j] = A[i][j+1];
                }
            }
            else{
                for (int j = 0; j < result[i].length; j++) {
                    if (j<n-1) {
                        result[i][j] = A[i+1][j];
                    }
                    else result[i][j] = A[i+1][j+1];
                }
            }
        }
        return result;
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
