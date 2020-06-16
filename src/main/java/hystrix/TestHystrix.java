package hystrix;

public class TestHystrix {
    public static void main(String[] args) {

        for (int i = 0; i <510; i++) {
            try {
                MyHytrixCommand hytrixCommand = new MyHytrixCommand(new HelloService());
                Thread.sleep(200);
                System.out.println(hytrixCommand.execute());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <510; i++) {
            try {
                MyHytrixCommand hytrixCommand = new MyHytrixCommand(new HelloService());
                System.out.println();
                System.out.println(hytrixCommand.execute());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
