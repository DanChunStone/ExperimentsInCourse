package RemoveDuplicateElements;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("请输入十个整数：");
        Scanner input = new Scanner(System.in);
        for (int i = 0;i < 10;i++)
            list.add(input.nextInt());

        removeDuplicate(list);

        System.out.print("去重后，其中元素为：");
        for(int each : list) {
            System.out.printf("%-3d",each);
        }
        System.out.println();
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();

        for(int e:list) {
            boolean b = false;

            //判断在新list中是否已经存在该元素
            for(int each:newList) {
                if(e == each)
                    b = true;
            }

            if(!b) {
                newList.add(e);
            }
        }

        list.clear();

        for (int each:newList)
            list.add(each);
    }
}
