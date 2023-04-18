import java.io.*;


public class FileReader {
    public static String readFile(String filePath) throws IOException{
        //File f = new File(filePath);//首先得使用 File() 方法来创建一个文件对象
        FileInputStream in = new FileInputStream(filePath);
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return new String(outputStream.toByteArray(), "UTF-8");
        } finally {
            in.close();
        }

    }
    
    
}
