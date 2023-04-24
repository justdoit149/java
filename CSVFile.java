import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CSVFile {
    
	public static void main(String[] args) {
		String filePath = CSVFile.class.getClassLoader().getResource("data.txt").getPath();
		printCSVFile(filePath);
	}
	
	public static void printCSVFile(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Last    First    Salary");
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String output = String.join("    ", values);
                System.out.println(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
}
