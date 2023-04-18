import java.util.*;


public class HeartRateCalculation {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("RestingHR:");
        double RestingHR = scan.nextDouble();
        System.out.println("Age:");
        double Age = scan.nextDouble();
        System.out.println("Intensity|TargetHeartRate");
        System.out.println("---------|---------------");
        double Intensity = 0.55;
        for(int i = 0; i < 9; i++){
            System.out.printf("%d%%      |", 55 + 5 * i);
            double TargetHeartRate =(((220 - Age) - RestingHR) * Intensity) + RestingHR;
            Intensity = Intensity + 0.05;
            System.out.printf("%dbpm\n", (int)Math.round(TargetHeartRate));//用Math四舍五入
        }
        scan.close();
	}

}
