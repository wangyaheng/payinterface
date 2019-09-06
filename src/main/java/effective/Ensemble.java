package effective;

public enum Ensemble {
    LOLO(1),DUET(2),DIRECTOR(3);

    private final int num ;
    Ensemble(int num){this.num = num;}

    public int num(){return this.num;}
}
