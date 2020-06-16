package other.designpatten.dynamicproxy;

public class DaoImpl implements Dao{
    @Override
    public void login(String s) {
        System.out.println(s);
    }
}
