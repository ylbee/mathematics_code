package cn.yl.task5;

import java.util.Scanner;

/**
 * The method of Scalar multiplication of a Matrix
 * Task 5
 * @author : Yang Li
 * @version : v1.0
 * @createTime : 2023/5/7 12:03
 */
public class ScalarMultiplication {
    static   Scanner in;
    public static void main(String[] args) {
        in= new Scanner(System.in);
        System.out.println("Enter Scalar Matrix Rows & Columns :  ");
        int rows=in.nextInt();
        int columns= in.nextInt();
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the First Matrix Items :  ");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println("Please Enter the Multiplication Value :  ");
        int value = in.nextInt();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.format("%d \t",value * matrix[i][j]);
            }
            System.out.println();
        }
    }
}
