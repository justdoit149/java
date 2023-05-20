public class Exception {
    public static void main(String[] args) throws java.lang.Exception{
        try{//这个exception可以在函数里也可以在外面，有一个就行。
            //可以import这个包这样就不用每次都用全名了
            System.out.println(divide(3,2));
        }catch(java.lang.Exception yyy){
            System.out.println("ERROR");
        }
        
    }
    public static double divide(int i, int j) throws java.lang.Exception{
        try{
            return i * 1.0 / j;
        }catch(ArithmeticException xxx){
            throw new java.lang.Exception("除数为0");
        }
    }
}
