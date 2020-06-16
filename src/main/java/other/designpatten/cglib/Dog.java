package other.designpatten.cglib;

/**
 * cglib是生成一个子类继承需要被代理的类因此不能用final修饰
 */
public class Dog {

    public void call(){
        System.out.println("wang wang wang !!!");
    }
}
