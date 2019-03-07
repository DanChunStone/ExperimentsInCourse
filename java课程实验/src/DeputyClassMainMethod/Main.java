package DeputyClassMainMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("这里是主类，以下为传给副类的参数：");
        String[] x1 = {"人生而自由,","却无往不在枷锁之中。"};
        for (String each:x1) {
            System.out.println(each);
        }
        System.out.println("----------------------------");
        Deputy.main(x1);
    }
}

class Deputy {
    public static void main(String[] args) {
        System.out.println("这里是副类，以下是传入的参数：");
        for(String each : args) {
            System.out.println(each);
        }
    }
}