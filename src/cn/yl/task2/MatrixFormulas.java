package cn.yl.task2;


import java.util.Arrays;
import java.util.Scanner;

/**
 * The method of adding 、mutil、 multiplying
 *
 * @author : Yang Li
 * @version : v1.0
 * @createTime : 2023/4/20 12:03
 */
public class MatrixFormulas {
    // m and n for the first matrix
    private static int m1;
    private static int n1;
    // m and n for the second matrix
    private static int m2;
    private static int n2;
    // Entered the number of sentence matrices
    private static boolean count;
    // input stream
    private static Scanner scan;

    // matrix 1
    private static Matrix mat1;
    // matrix 2
    private static Matrix mat2;

    // Processing input error
    private static boolean flag;

    public static void main(String[] args) {
        scan=new Scanner(System.in);
        while (true)
        {
            System.out.println("-----------------Select the type of calculation: 1:add, 2:multiply ,3:minus----------------");
            System.out.print("Please Select 1:add, 2:multiply, 3:minus");
            int i = scan.nextInt();
            if(i==1){
                System.out.println("-----------------matrix plus----------------");
                // First input
                count=true;
                readFirst();
                // Second input
                count=false;
                readFirst();
                // result
                Matrix plus = Matrixs.plus(mat1, mat2);
                plus.print();
            }
            if(i==2){
                System.out.println("-----------------matrix multiplication----------------");
                // First input
                count=true;
                readFirst();
                // Second input
                count=false;
                readFirst();
                // result
                Matrix mutil = Matrixs.mutil(mat1, mat2);
                mutil.print();
            }
            if(i==3){
                System.out.println("-----------------matrix minus----------------");
                // First input
                count=true;
                readFirst();
                // Second input
                count=false;
                readFirst();
                // result
                Matrix mutil = Matrixs.minus(mat1, mat2);
                mutil.print();
            }
            System.out.print("Enter 0 to continue:");
            i = scan.nextInt();
            if (i!=0)
            {
                break;
            }
            // Processing input error
            flag=true;
        }
    }
    // Read matrix
    private static void readFirst() {
        scan.nextLine();
        while(true)
        {
            String c=count?"1":"2";
            System.out.print("Please enter the rows and columns (m n) of the " + c +" matrix A:");
            String s = scan.nextLine();
            String[] s1 = s.trim().split(" ");
            if (s1!=null&&s1.length!=2)
            {
                System.out.println("erro! re-enter:");
                continue;
            }
            //  analysis
            if (count)
            {
                m1=Integer.parseInt(s1[0]);
                n1=Integer.parseInt(s1[1]);
            }
            else
            {
                m2=Integer.parseInt(s1[0]);
                n2=Integer.parseInt(s1[1]);
            }
            double [][] d1=new double[Integer.parseInt(s1[0])][Integer.parseInt(s1[1])];
            System.out.println("Please enter the data of the matrix:");
            System.out.println("Press Enter,if you need to enter more than one line");
            for (int i=0;i<Integer.parseInt(s1[0]);i++)
            {
                // Assign values line by line
                System.out.print("First "+(i+1)+" row:");
                String s2 = scan.nextLine();
                String[] s3 = s2.trim().split(" ");
                if (s3.length!=Integer.parseInt(s1[1]))
                {
                    // enter again
                    i--;
                    System.out.println("Please enter again,input format error!");
                    continue;
                }
                for (int j=0;j<Integer.parseInt(s1[1]);j++)
                {
                    d1[i][j]=Double.parseDouble(s3[j]);
                }
            }
            // assignment
            if(count)
            {
                mat1=new Matrix(d1);
                break;
            }
            else
            {
                mat2=new Matrix(d1);
                break;
            }
        }
    }

}
class Matrix {

    // matrix
    private double[][] matrix;
    // m x n
    private int m;
    private int n;

    public double[][] getMatrix() {
        return matrix;
    }
    public Matrix() {
    }
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.m=matrix.length;
        this.n=matrix[0].length;
    }
    public Matrix(int m, int n) {
        this.matrix=new double[m][n];
        this.m=m;
        this.n=n;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
        this.m=matrix.length;
        this.n=matrix[0].length;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    //  print matrix
    public void print()
    {
        System.out.println("------------------result-------------------");
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
class Matrixs {
    /**
     * Implement matrix addition
     * @param p1 matrices 1
     * @param p2 matrices 2
     * @return Returns null if the matrix is not additive
     */
    public static Matrix plus(Matrix p1, Matrix p2) {
        if (p1!=null&&p2!=null) {
            if (p1.getM()== p2.getM()&&p1.getN()== p2.getN()) {
                double[][] m1 = p1.getMatrix();
                double[][] m2 = p2.getMatrix();
                // The condition for matrix additivity is satisfied
                // Creating matrices
                Matrix m=new Matrix();
                double [][] m_data=new double[p1.getM()][p1.getN()];
                for (int i=0;i< p1.getM();i++)
                {
                    // a[0]
                    for (int j=0;j< p1.getN();j++)
                    {
                        m_data[i][j]=m1[i][j]+m2[i][j];
                    }
                }
                m.setMatrix(m_data);
                return m;
            }
            else{
                // Matrix unaddable
                System.out.println("Matrix unaddable!");
                return null;
            }
        }
        return null;
    }


    /**
     * Realize matrix multiplication
     * @param p1 matrices 1
     * @param p2 matrices 2
     * @return Returns null if the matrix is not multiplicable
     */
    public static Matrix mutil(Matrix p1, Matrix p2)
    {
        if (p1!=null&&p2!=null)
        {
            // Determine whether matrices can be multiplied
            if (p1.getN()==p2.getM())
            {
                double[][] m1 = p1.getMatrix();
                double[][] m2 = p2.getMatrix();
                // Matrix multiplicability
                double [][] m =new double[p1.getM()][p2.getN()];
                for (int i=0;i<p1.getM();i++)
                {
                    for (int j=0;j<p2.getN();j++)
                    {
                        double a=0;
                        // core
                        for (int k=0;k<p1.getN();k++)
                        {
                            a+=m1[i][k]*m2[k][j];
                        }
                        m[i][j]=a;
                    }
                }
                return new Matrix(m);
            }
            else
            {
                // Matrix unmultiplicable
                System.out.println("Matrix unmultiplicable!");
                return null;
            }
        }
        return null;
    }

    /**
     * Implement matrix minus
     * @param p1 matrices 1
     * @param p2 matrices 2
     * @return Returns null if the matrix is not minusitive
     */
    public static Matrix minus(Matrix p1, Matrix p2) {
        if (p1!=null&&p2!=null) {
            if (p1.getM()== p2.getM()&&p1.getN()== p2.getN()) {
                double[][] m1 = p1.getMatrix();
                double[][] m2 = p2.getMatrix();
                // The condition for matrix subtractability is satisfied
                // Creating matrices
                Matrix m=new Matrix();
                double [][] m_data=new double[p1.getM()][p1.getN()];
                for (int i=0;i< p1.getM();i++)
                {
                    // a[0]
                    for (int j=0;j< p1.getN();j++)
                    {
                        m_data[i][j]=m1[i][j]-m2[i][j];
                    }
                }
                m.setMatrix(m_data);
                return m;
            }
            else{
                // Matrix unaddable
                System.out.println("Matrix unaddable!");
                return null;
            }
        }
        return null;
    }
}