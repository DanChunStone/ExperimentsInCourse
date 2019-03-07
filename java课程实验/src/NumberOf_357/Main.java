package NumberOf_357;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入一个数：");
        String number = input.nextLine();
        BigInteger num = new BigInteger(number);

        int counter = 0;

        for(int i = 0;num.compareTo(new BigInteger("" +
                (int)Math.pow(3,i))) >= 0;i++) {
            for(int j = 0;num.compareTo(new BigInteger("" +
                    (int)Math.pow(5,j))) >= 0;j++) {
                for(int k = 0;num.compareTo(new BigInteger("" +
                        (int)Math.pow(7,k))) >= 0;k++) {
                    BigInteger x = new BigInteger("" + (int)Math.pow(3,i));
                    BigInteger y = new BigInteger("" + (int)Math.pow(5,j));
                    BigInteger z = new BigInteger("" + (int)Math.pow(7,k));

                    BigInteger sum = x.multiply(y).multiply(z);
                    if(num.compareTo(sum) >= 0 && i+j+k !=0) {
                        counter++;
                    }
                }
            }
        }

        System.out.println(counter);
        BigInteger v = new BigInteger("59084709587505");
    }
}
