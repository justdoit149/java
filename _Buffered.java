//使用Buffered缓冲来实现控制台、文件的读写。
import java.io.*;
import java.io.FileReader;


public class _Buffered {
    public static void main(String[] args) {
        // 控制台输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(br.read());
        } catch (IOException e) {
            // 
        }

        // 文件输入
        File f = new File("./data.txt");
        BufferedReader br2 = null;
        try {
            br2 = new BufferedReader(new FileReader(f));
            try {
                String s = null;
                String[] S = null;
                while((s = br2.readLine()) != null){//读取，返回字符串
                    System.out.println(s);
                    S = s.split(",");//分隔，返回字符串数组
                    for(int i = 0; i < S.length; i++){
                        System.out.println(S[i]);
                    }
                }
            } catch (IOException e) {
                // 
            }
        } catch (FileNotFoundException e) {
            // 
        }finally{
            try {
                br2.close();
            } catch (IOException e) {
                // 
            }
        }

        //文件输出
        File f2 = new File("./data.txt");
        BufferedWriter br3 = null;
        try {
            br3 = new BufferedWriter(new FileWriter(f2));
            br3.flush();//清空原来的文件
            br3.write("se,ewq");//写入，参数可以是字符串、字符等
            br3.write(",3sad");
            br3.newLine();//写入换行符
            int a = 101;
            br3.write("sad,io\nxc," + a);
            br3.write(a);//这个实际上是写入(char)a
            br3.newLine();
        } catch (IOException e) {
            // 
        }finally{
            try {
                br3.close();
            } catch (IOException e) {
                // 
            }

        }
    }
}
