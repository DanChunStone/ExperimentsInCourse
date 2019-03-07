package BeansGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入豆子个数和卡槽个数：");

        int number = input.nextInt();
        int length = input.nextInt();

        //记录豆子路径
        Boolean[][] path = new Boolean[number][length - 1];
        //记录结果
        int[] conclusion = new int[length];

        for (int i = 0;i < number;i++) {
            int x = 0;
            for (int j = 0;j < length - 1;j++) {
                if(Math.random() > 0.5) {
                    x++;
                    path[i][j] = true;
                }
                else {
                    path[i][j] = false;
                }
            }
            conclusion[x]++;
        }

        for (int i = 0;i < number;i++) {
            for (int j = 0; j < length - 1; j++)
                System.out.print(path[i][j] ? "右" : "左");
            System.out.println("");
        }
        System.out.println("");

        int max = 0;
        for (int each:conclusion)
            if (each>max)
                max = each;

        //打印豆子结果
        for (int i = max+1;i > 0;i--) {
            System.out.print("|");
            for (int j = 0;j < length;j++) {
                if(conclusion[j] >= i)
                    System.out.print("*|");
                else
                    System.out.print(" |");
            }
            System.out.println("");
        }
        System.out.print("¯");
        for (int j = 0;j < length;j++) System.out.print("¯¯");
    }
}
