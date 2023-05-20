import java.io.*;
// import java.io.FileReader;

public class IOTest{
	// public static void main(String[] args){
	// 	FileInputStream f = null;
	// 	try {
	// 		f = new FileInputStream("./data.txt");
	// 		int c = -1;
	// 		try {
	// 			while((c = f.read()) != -1){
	// 				System.out.print((char)c);
	// 			}
	// 		} catch (IOException e) {
	// 			// 
	// 		}
			
	// 	} catch (FileNotFoundException e) {
	// 		//
	// 	}finally{
	// 		try {
	// 			f.close();
	// 		} catch (IOException e) {
	// 			//
	// 		}
	// 	}
	// }

	public static void main(String[] args) throws IOException{
		//这是一起抛出异常的版本，前面注释掉的是每次分别抛出异常的
		// BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		FileInputStream f = new FileInputStream("./data.txt");//输入流
		int c = -1;
		char[] out = new char[1005];
		for(int i = 0; (c = f.read()) != -1; i++){//f.read()逐字符读取并返回ascii码
			out[i] = (char)c;	//数据放到字符数组里
		}
		System.out.println(out);//最后输出字符数组
		f.close();//最后关闭流
	}
}