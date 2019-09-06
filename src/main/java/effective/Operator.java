package effective;

public class Operator {

    public static <T extends Enum<T> & Operation> void test(Class<T> clazz,double x,double y){
        clazz.getEnumConstants();
    }
}
