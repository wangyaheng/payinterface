package generic;

public class TestGen {

    public static void main(String[] args) {
        t(new A<B>());
    }

    private static void t(A<?> a){
        System.out.println(a.a());
    }
}
