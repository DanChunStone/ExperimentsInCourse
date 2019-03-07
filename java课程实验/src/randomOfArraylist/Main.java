package randomOfArraylist;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < 15;i++) {
            list.add((int)(Math.random() * 100));
        }

        System.out.println("打乱前，顺序为：");
        showList(list);

        System.out.println("打乱后，顺序为：");
        shuffle(list);
        showList(list);
    }

    public static void shuffle(ArrayList<Integer> list) {
        for(int i = 0;i < list.size();i++) {
            int index = (int)(Math.random()*list.size());
            int a = list.get(i);
            int b = list.get(index);

            list.set(i,b);
            list.set(index,a);
        }
    }

    public static void showList(ArrayList<Integer> list) {
        for(Integer each : list) {
            System.out.printf("%-3d",each);
        }
        System.out.println();
    }
}
