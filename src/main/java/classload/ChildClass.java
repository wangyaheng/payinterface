package classload;

public class ChildClass extends ParentClass{

    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
    }
    
    public ChildClass(){
        System.out.println("child");
    }
}
