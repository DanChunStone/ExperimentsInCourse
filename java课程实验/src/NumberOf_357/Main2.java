package NumberOf_357;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入一个数：");
        long number = input.nextLong();

        int counter = 0;

        for(int i = 0;(long)Math.pow(3,i) <= number;i++) {
            for(int j = 0;(long)Math.pow(5,j) <= number;j++) {
                for(int k = 0;(long)Math.pow(7,k) <= number;k++) {
                    if((long)(Math.pow(3,i)*Math.pow(5,j)*Math.pow(7,k)) <= number && i+j+k !=0) {
                        counter++;
                    }
                }
            }
        }

        System.out.println(counter);
//        BigInteger v = new BigInteger("59084709587505");
    }
}
