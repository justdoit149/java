//package edu.nju;
import java.util.*;
/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		int m = A.length;//获取二维数组的行数和列数
        int n = A[0].length;
        int C[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
		return C;
	}
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		int m = A.length;//获取二维数组的行数和列数
        int n = A[0].length;
        int p = B[0].length;
        int C[][] = new int[m][p];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < p; j++){
                C[i][j] = 0;
                for(int k = 0; k < n; k++){
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
		return C;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole(){
        Scanner scan = new Scanner(System.in);
		int m,n;
        m = scan.nextInt();
        n = scan.nextInt();
        int A[][] = new int[m][n];
        int B[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                A[i][j] = scan.nextInt();
            }
        }
        m = scan.nextInt();
        n = scan.nextInt();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                B[i][j] = scan.nextInt();
            }
        }
        int C[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        scan.close();
		return C;
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole(){
		Scanner scan = new Scanner(System.in);
		int m,n,p;
        m = scan.nextInt();
        n = scan.nextInt();
        int A[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                A[i][j] = scan.nextInt();
            }
        }
        n = scan.nextInt();
        p = scan.nextInt();
        int B[][] = new int[n][p];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < p; j++){
                B[i][j] = scan.nextInt();
            }
        }
        int C[][] = new int[m][p];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < p; j++){
                C[i][j] = 0;
                for(int k = 0; k < n; k++){
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        scan.close();
		return C;
	}

	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 *
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 *
	 */
	public void print(int[][] A){
		int m = A.length;
        int n = A[0].length;
        System.out.println();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n-1; j++){
                System.out.printf("%d ",A[i][j]);
            }
            System.out.printf("%d\n",A[i][n-1]);
        }
	}
}
