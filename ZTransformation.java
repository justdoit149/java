//import java.io.*;
import java.util.*;   //为了通过 Scanner 类来获取用户的输入

public class ZTransformation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //创建 Scanner 对象
        String str = scanner.nextLine();// 读取输入的字符串和整数n
        int n = scanner.nextInt();
        int len = str.length();// 计算字符串长度
        char[][] coord = new char[n][len + 5];// 创建一个二维数组，表示输出结果的坐标系
        int x = 0, y = 0;//起始位置
        for(int i = 0; i < n; i++){//初始化
            for(int j = 0; j < len + 5; j++){
                coord[i][j] = ' ';
            }
        }
        char[] ch = str.toCharArray();//字符串变为字符数组
        if(n >= 2 && len >= n){//n>=2需要z字输出
            for(int i = 0; i < len; i++){
                coord[x][y] = ch[i];
                if(y % (2 * (n - 1)) == 0 && x < n-1){//向下
                    x += 1;
                }else{//向右上
                    y += 2; 
                    x -= 1;
                }
            }
            for(int i = 0; i < n; i++){//确定每一行的结尾，这也是为什么需要单独讨论len<n的原因
                for(int j = len; ; j--){
                    if(coord[i][j] != ' '){
                        coord[i][j+1] = '\n';
                        break;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; ; j++){
                    System.out.print(coord[i][j]);
                    if(coord[i][j] == '\n'){
                        break;
                    }
                }
            }
        }else if(len >= n){//n==1则直接输出（字符间有空格）
            for(int i = 0; i < len - 1; i++){
                System.out.print(ch[i]+" ");
            }
            System.out.println(ch[len-1]);
        }else{//len<n的话输出不够n行，导致后面几行没有内容（按照前面代码执行会越界）
            for(int i = 0; i < len; i++){
                System.out.println(ch[i]);
            }
        }
        scanner.close();
    }
}
