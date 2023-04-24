import java.util.*;;
//Math类在java.lang包下，不需要import


public class ResponseTimeCalculation {

	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //arraylist也来自java.util
        ArrayList<Integer> nums = new ArrayList<Integer>();//<E>只能为引用数据类型
        //如果想用基本类型的话需要用其包装类
        int sum = 0;
        double average = 0, sd = 0;

        while(true){
            System.out.println("Enter a Number:");
            String a = scan.nextLine();
            if(a.equals("done")){
                break;
            }
            nums.add(Integer.parseInt(a));
        }
        
        System.out.print("Numbers:");
        for(int i = 0; i < nums.size()-1; i++){
            System.out.printf("%d,",nums.get(i));//用get来访问
        }
        System.out.println(nums.get(nums.size()-1));
        Collections.sort(nums);//util里的类，对arraylist排序
        for(int i = 0; i < nums.size(); i++){//arraylist用size，数组用length
            sum = sum + nums.get(i); 
        }
        average = sum * 1.0 / nums.size(); 
        for(int i = 0; i < nums.size(); i++){
            sd = sd + Math.pow(nums.get(i) - average,2);
        }
        sd = Math.sqrt(sd / nums.size());

        System.out.printf("The average is %.2f.\n",average);
        System.out.printf("The minimum is %d.\n",nums.get(0));
        System.out.printf("The maximum is %d.\n",nums.get(nums.size()-1));
        System.out.printf("The standard deviation is %.2f.\n",sd);
        scan.close();
	}
	
}
