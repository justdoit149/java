public class Test{
    public static void main(String[] args) {
        father f = new son();
        f.func();
        System.out.println(f.a);
    }
    static class father{
        int a = 10;
        void func(){
            System.out.println("father");
        }

    }
    static class son extends father{
        int a = 100;
        void func(){
            System.out.println("son");
            System.out.println(a);
        }
    }
}