import java.util.*;

public class FindPrimes {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 0; i < n; i++){
            int x = s.nextInt();
            for(int j = 2; j <= x / 2; j++){
                if(Isprime(j) && Isprime(x-j)){
                    System.out.printf("%d %d\n",j,x-j);
                    break;
                }
            }
        }
        s.close();
    }
    public static boolean Isprime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }   
}
