//import java.io.*;
import java.util.*;
public class CurrencyExchange {
    public static void main(String[] args){
        double euros, exchange, dollars;
        //String temp = null;
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in); //?
        System.out.println("How many euros are you exchanging?");
        euros = s.nextDouble();
        System.out.println("What is the exchange rate? ");
        exchange = s.nextDouble();
        dollars = euros * exchange / 100;
        System.out.printf("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.",euros,exchange,dollars);

    }
}
