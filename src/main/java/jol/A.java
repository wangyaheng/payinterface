package jol;

import java.util.Objects;

public class A implements Cloneable{
    public boolean flag;

    void isFlag(){
        Objects.hash(flag);
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode((short) 1);
        result = 31*result+Boolean.hashCode(flag);

        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
