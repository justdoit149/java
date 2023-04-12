//import java.io.*;
import java.util.*;

public class ZTransformation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // 读取输入的字符串和整数n
        String str = scanner.nextLine();
        int n = scanner.nextInt();

        // 计算每行输出的字符数
        int len = str.length();
        // 创建一个二维数组，表示输出结果的坐标系
        char[][] coord = new char[n][len + 5];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < len + 5; j++){
                coord[i][j] = ' ';
            }
        }
        int x = 0, y = 0;//起始位置
        char[] ch = str.toCharArray();//字符串变为字符数组
        if(n >= 2 && len >= n){
            for(int i = 0; i < len; i++){
                coord[x][y] = ch[i];
                if(y % (2 * (n - 1)) == 0 && x < n-1){
                    x += 1;
                }else{
                    y += 2; 
                    x -= 1;
                }
            }
            for(int i = 0; i < n; i++){
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
        }else if(len >= n){
            for(int i = 0; i < len - 1; i++){
                System.out.print(ch[i]+" ");
            }
            System.out.println(ch[len-1]);
        }else{
            for(int i = 0; i < len; i++){
                System.out.println(ch[i]);
            }
        }
        scanner.close();
    }
}
