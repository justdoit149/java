import java.util.*;


public class Literal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim();//本题采用正则表达式来处理匹配。
        if (input.matches("\\d+")) {//\d匹配一个，\d+匹配一个或多个，\\d的前一个'\'是转义字符
            System.out.println("integer");
        }else if(input.matches("\\d+L")){
            System.out.println("long");
        }else if(input.matches("\\d+\\.\\d+f")){
            System.out.println("float");
        }else if(input.matches("\\d+\\.\\d+")){
            System.out.println("double");
        }else if(input.matches("'.'")){
            System.out.println("char");
        }else if(input.equals("true") || input.equals("false")){//字符串比较
            System.out.println("boolean");
        }
        
        scan.close();
    }
}
