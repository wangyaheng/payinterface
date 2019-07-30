package effective;

import org.junit.Test;

public class TestEffectice {

    @Test
    public void testEffective(){

        AClass a = new AClass();
        a.getA();
        System.out.println(AInterface.a);
    }
}
