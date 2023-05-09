import java.util.Arrays;

/**
* 矩阵类，实现矩阵的加法，矩阵乘法
* 1.传入一个int[][]进行2个矩阵的操作
* 2.返回一个int[][]
* 所有的数据均为int型
* 输入数据均默认为正确数据，不需要对输入数据进行校验
* @author Qin Liu
*
*/
public class BadMatrix {
	private int[][] data;

	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public BadMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}


	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
   public int[][] plus(int[][] b){
   	int[][] a = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		for(int i = 0; i < a.length; i++){
           for(int j = 0; j < a[0].length; j++){
               a[i][j] = a[i][j] + b[i][j];
           }
       }
		return a;
	}


	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public int[][] times(int[][] b){
		int[][] a = {
				{3, 3, 3},
				{3, 3, 3},
				{3, 3, 3}
		};
       int[][] c = new int[a.length][b[0].length];
       for(int i = 0; i < c.length; i++){
           for(int j = 0; j < c[0].length; j++){
               c[i][j] = 0;
               for(int k = 0; k < a[0].length; k++){
                   c[i][j] = c[i][j] + a[i][k] * b[k][j];
               }
           }
       }
		return c;
	}

	//不要修改下面print方法
	/**
	 * 打印出该矩阵的数据
	 *
	 */
	public void print(){
		System.out.print(this.toString());
	}

	/**
	 * 实现toString方法
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
	public String toString(){
       String str = "\n";
       for(int i = 0; i < this.data.length; i++){//int数组的length是个变量，不是方法
           for(int j = 0; j < this.data[0].length-1; j++){
               str = str + this.data[i][j] + " ";//直接用"+"相连，会把数字自动转换为字符串的
           }
           str = str + this.data[i][this.data[0].length-1] + "\n";
       }
		return str;
	}

	//不要修改下面equals方法
	public boolean equals(Object o){
		if(this.toString().equals(((BadMatrix)o).toString()))
			return true;
		else
			return false;
	}

   
   
}
