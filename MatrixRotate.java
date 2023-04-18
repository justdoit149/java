import java.util.*;

public class MatrixRotate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m,n,t;
        m = scan.nextInt();
        n = scan.nextInt();
        int[][] nums = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                nums[i][j] = scan.nextInt();
            }
        }
        t = scan.nextInt();
        t = (t / 90) % 4;
        if(t == 0){//翻转不用真的操作数组，只改变读取方式即可。不过这里可以试着封装成一个方法
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n-1; j++){
                    System.out.printf("%d ",nums[i][j]);
                }
                System.out.printf("%d\n",nums[i][n-1]);
            }
        }else if(t == 1){
            for(int j = 0; j < n; j++){
                for(int i = m-1; i > 0; i--){
                    System.out.printf("%d ",nums[i][j]);
                }
                System.out.printf("%d\n",nums[0][j]);
            }
        }else if(t == 2){
            for(int i = m-1; i >= 0; i--){
                for(int j = n-1; j > 0; j--){
                    System.out.printf("%d ",nums[i][j]);
                }
                System.out.printf("%d\n",nums[i][0]);
            }
        }else{
            for(int j = n-1; j >= 0; j--){
                for(int i = 0; i < m-1; i++){
                    System.out.printf("%d ",nums[i][j]);
                }
                System.out.printf("%d\n",nums[m-1][j]);
            }
        }

        scan.close();
    }
}
