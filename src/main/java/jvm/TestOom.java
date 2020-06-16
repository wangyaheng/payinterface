package jvm;

import java.util.ArrayList;
import java.util.List;

public class TestOom {

    public static void main(String[] args) {
        List<TestOom> list = new ArrayList<TestOom>();
        while (true) {
            list.add(new TestOom());
        }
    }
}
