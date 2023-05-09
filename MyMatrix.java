/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */

import java.util.*;


public class MyMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}


	public MyMatrix plus(MyMatrix B){//MyMatrix类就是一个要实现的矩阵类
		//这个类里有一个private的矩阵，有对这个矩阵进行操作的一系列public方法
		//比如这个plus方法，参数是另一个矩阵类，要把这两个矩阵类里的矩阵相加，然后可以开一个新的矩阵类return
		//也可以修改本矩阵类然后返回this
		//体会这其中的面向对象思想。
		int[][] data2 = B.getData();//调用别的private应当通过其提供的public方法
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[0].length; j++){
				data[i][j] += data2[i][j];
			}
		}
		return this;
	}

	

	public MyMatrix times(MyMatrix B){
		int[][] data1 = this.data;//先拷贝一份当前的矩阵，然后改变
		int[][] data2 = B.getData();
		int m = data.length, n = B.data[0].length;
		this.data = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				this.data[i][j] = 0;
				for(int k = 0; k < B.data.length; k++){
					this.data[i][j] += data1[i][k] * data2[k][j];
				}
			}
		}
		return this;
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[0].length; j++){
				data[i][j] *= b;
			}
		}
		return this;
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		int[][] data1 = this.data;
		this.data = new int[data[0].length][data.length];
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[0].length; j++){
				data[j][i] = data1[i][j];
			}
		}
		return this;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
		Scanner scan = new Scanner(System.in);
		int m,n;
		m = scan.nextInt();
		n = scan.nextInt();
		int data2[][] = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				data2[i][j] = scan.nextInt();
				data[i][j] += data2[i][j];
			}
		}
		scan.close();
		return this;
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		Scanner scan = new Scanner(System.in);
		int m,n;
		m = scan.nextInt();
		n = scan.nextInt();
		int A[][] = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				A[i][j] = scan.nextInt();
			}
		}
		int C[][] = new int[data.length][n];
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < n; j++){
				C[i][j] = 0;
				for(int k = 0; k < m; k++){
					C[i][j] += data[i][k] * A[k][j];
				}
			}
		}
		data = C;
		scan.close();
		return this;
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
	public void print(){
		int m = data.length;
		int n = data[0].length;
		System.out.println();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n-1; j++){
				System.out.printf("%d ",data[i][j]);
			}
			System.out.printf("%d",data[i][n-1]);
			System.out.println();
		}
		System.out.println();
	}
}
//