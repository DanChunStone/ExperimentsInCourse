package SumOfArray;


public class Main {
    public static void main(String[] args) {
        int[] num = new int[20];
        for(int i = 0;i < num.length;i++) {
            num[i] = (int)(Math.random()*100);
        }

        int sum = 0;
        System.out.print("随机数列为：");
        for(int each : num) {
            sum += each;
            System.out.print(each + " ");
        }
        System.out.println();
        System.out.println("该数列的和为：" + sum);
    }
}

