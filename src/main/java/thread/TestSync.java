package thread;



public class TestSync {
    volatile int a = 5;

    public static void main(String[] args) {

    }
    public void get(){
        System.out.println(a++);
        synchronized (new TestSync()){
            System.out.println("aaa");
        }

    }
}
