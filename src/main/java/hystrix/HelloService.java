package hystrix;



public class HelloService {

    public String sayHello(){
        System.out.println("hello");
        int a = 1/0;
        return "hello";
    }
}
