package algorithm;

public class Change {
    public static void main(String[] args) {
        System.out.println(change("afdsdaAd3435AdfF"));


        int a = 7;
        int count = 0;
        while(a>0){
            count++;
            a=a&(a-1);
        }
        System.out.println(count);
    }

    private static String change(String line) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i)>='A'&&line.charAt(i)<='Z'){
                builder.append((char)(line.charAt(i)+32));
            }else if(line.charAt(i)>='a'&&line.charAt(i)<='z'){
                builder.append((char)(line.charAt(i)-32));
            }
        }
        return builder.toString();
    }
}
