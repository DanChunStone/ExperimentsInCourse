
public class Main {
    public static void main(String[] args) {
        String[] x = new String[10];
        for (int i = 0;i < 10;i++) {
            x[i] += i;
        }

        for (String each : x) {
            System.out.println(each);
        }
    }
}
