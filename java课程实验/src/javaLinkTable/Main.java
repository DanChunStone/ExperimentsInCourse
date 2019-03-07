package javaLinkTable;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choose = 1;
        LinkTable data = new LinkTable(6);
        Scanner input = new Scanner(System.in);

        while (choose!=0) {
            System.out.println("------ 链表操作 ------");
            System.out.println("1、随机新建一个链表");
            System.out.println("2、随机生成一个数插入链表尾");
            System.out.println("3、输入一个数插入链表指定位置");
            System.out.println("4、取指定位置的元素");
            System.out.println("5、删除指定位置的元素");
            System.out.println("6、判断链表是否为空");
            System.out.println("7、清空链表");
            System.out.println("0、退出");
            System.out.println("---------------------");
            data.showLinkTable();
            System.out.println("请输入您的操作：");
            choose = input.nextInt();

            switch (choose) {
                case 0:break;
                case 1:
                    data = new LinkTable((int)(Math.random()*10));
                    break;
                case 2:
                    data.EnLinkTable((int)(Math.random()*100));
                    break;
                case 3:
                    System.out.print("请输入你要插入的数以及位置：");
                    data.InsertInTo(input.nextInt(),input.nextInt());
                    break;
                case 4:
                    System.out.print("请输入你要取的数的位置：");
                    int n[] = {0};
                    System.out.println(data.getByIndex(input.nextInt(),n)?"该位置的元素为：" + n[0]:"下标不符合要求");
                    break;
                case 5:
                    System.out.print("请输入你要删除的元素的位置：");
                    Integer g = 0;
                    System.out.println(data.DeLinkTable(input.nextInt(),g)?"成功删除该元素":"下标不符合要求，删除失败");
                    break;
                case 6:
                    System.out.println(data.isEmpty()?"当前链表为空":"当前链表不为空");
                    break;
                case 7:
                    data.clear();
                    System.out.println("当前链表已清空");
                    break;
            }
        }
    }
}

class LinkTable {
    private ArrayList<Integer> data;

    public LinkTable() {
        data = new ArrayList<>();
    }
    public LinkTable(int num) {
        data = new ArrayList<>(num);
        for (int i = 0;i < num;i++) {
            data.add((int)(Math.random()*100));
        }
    }

    public void EnLinkTable(int x) {
        data.add(x);
    }

    public void InsertInTo(int x,int y) {
        data.add(y,x);
    }

    public boolean DeLinkTable(int y,Integer x) {
        if(!data.isEmpty() && y < data.size()) {
            x = data.remove(y);
            return true;
        }
        else
            return false;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean getByIndex(int x,int[] date) {
        if(data.size() > x) {
            date[0] = data.get(x);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return data.equals(obj);
    }

    @Override
    public String toString() {
        return "当前队列数据为：" + data.toString();
    }

    public void showLinkTable() {
        System.out.println("当前链表为：");

        for (int i = 0;i < data.size();i++ ) {
            if(i == 0) {
                System.out.printf("%-2s", "" + data.get(i));
            }
            else {
                System.out.printf("%-5s", "-->" + data.get(i));
            }
        }
        System.out.println();
    }

    public void clear() {
        data.clear();
    }
}