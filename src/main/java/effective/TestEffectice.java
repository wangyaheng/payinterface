package effective;


import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class TestEffectice {






    @Test
    public void testStringSplit(){
        String str = "scanCode,scanCode2";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println(s);
        }

    }
    @Test
    public void testNum(){
        System.out.println(19&(-19));
    }
    @Test
    public void testRandom(){
        for (int i = 0; i < 10; i++) {
            int i1 = ThreadLocalRandom.current().nextInt(100);
            System.out.println(i1);

        }
    }
    @Test
    public void testEffective2(){
        //Stream<BigInteger> iterate = Stream.iterate(new BigInteger("2"),BigInteger::nextProbablePrime);
        String str = "";
        str = Objects.requireNonNull("123","123");
        StringBuilder sb = new StringBuilder();
        sb.reverse();
        System.out.println(str);
    }
    @Test
    public void testEnum(){
        String [] s = new String[]{"1","2","1"};
        System.out.println(Ensemble.LOLO.num());
        EnumSet<Ensemble> lolo = EnumSet.of(Ensemble.LOLO, Ensemble.DIRECTOR);
        for (Ensemble ensemble : lolo) {
            System.out.println(ensemble);
        }
        Map<String, List<String>> collect = Arrays.stream(s).collect((groupingBy(s1 -> s1.toString() + "123")));
        Map<String,String> map = Arrays.stream(s).collect(toMap(s1->s1.toString(), s1->s1.toString()));
        //Map<String,String> map = Arrays.stream(s).collect(toMap);

        System.out.println(collect);


    }
    @Test
    public void testEffective(){

      /*  AClass a = new AClass();
        a.getA();
        System.out.println(AInterface.a);*/
        System.out.println(Ensemble.LOLO);
        System.out.println(Ensemble.valueOf("LOLO"));



        final Runnable runnable = () -> System.out.println();
        new Thread(runnable).start();

    }
}
