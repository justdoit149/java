import java.util.*;
// import java.math.*;

public class CompareNumbers {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int a = scan.nextInt();
        System.out.println("Enter the second number:");
        int b = scan.nextInt();
        System.out.println("Enter the third number:");
        int c = scan.nextInt();
        if(a == b || a == c || b == c){
            System.out.println("There are same numbers.");
        }else{
            System.out.printf("The largest number is %d.",Math.max(a,Math.max(b,c)));//?
        }     
        scan.close();
	}

}
