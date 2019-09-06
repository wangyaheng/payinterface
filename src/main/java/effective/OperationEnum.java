package effective;

public enum OperationEnum implements Operation{
    ADD("+") {
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    MINUX("-") {
        @Override
        public double apply(double x,double y) {
            return x-y;
        }
    },
    MULTI("*") {
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };
    private String calChar;

    OperationEnum(String calChar){this.calChar = calChar;}



}
