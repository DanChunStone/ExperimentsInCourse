package JavaQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choose = 1;
        Queue data = new Queue(6);
        Scanner input = new Scanner(System.in);

        while (choose!=0) {
            System.out.println("------ 队列操作 ------");
            System.out.println("1、随机新建一个队列");
            System.out.println("2、随机生成一个数入队列");
            System.out.println("3、输入一个数入队列");
            System.out.println("4、将一个元素出队列");
            System.out.println("5、判断队列是否为空");
            System.out.println("6、清空队列");
            System.out.println("0、退出");
            System.out.println("---------------------");
            data.showQueue();
            System.out.println("请输入您的操作：");
            choose = input.nextInt();

            switch (choose) {
                case 0:break;
                case 1:
                    data = new Queue((int)(Math.random()*10));
                    break;
                case 2:
                    data.EnQueue((int)(Math.random()*100));
                    break;
                case 3:
                    System.out.print("请输入你要入队的数：");
                    data.EnQueue(input.nextInt());
                    break;
                case 4:
                    int x = 0;
                    if(data.DeQueue(x)){
                        System.out.println("将：" + x + "出队列");
                    }
                    else{
                        System.out.println("队列为空，出队列失败");
                    }
                    break;
                case 5:
                    System.out.println(data.isEmpty()?"当前队列为空":"当前队列不为空");
                    break;
                case 6:
                    data.clear();
                    System.out.println("当前队列已清空");
                    break;
            }

        }
    }
}

class Queue{
    private ArrayList<Integer> data;

    public Queue() {
        data = new ArrayList<>();
    }

    public Queue(int x) {
        data = new ArrayList<>();
        for(int i = 0;i < x;i++) {
            data.add((int)(Math.random()*100));
        }
    }

    public void EnQueue(int x) {
        data.add(x);
    }
    public boolean DeQueue(Integer x) {
        if(!data.isEmpty()) {
            x = data.remove(0);
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

    public void showQueue() {
        System.out.println("当前队列为：");
        for (int i = 0;i < data.size();i++) {
            if(i==0) {System.out.print("头-");}
            else if(i+1==data.size()) {System.out.print(">尾");}
            else{System.out.printf("%-3s","---");}
        }
        System.out.println("");

        for (int each:data) {
            System.out.printf("%-3d",each);
        }
        System.out.println();
    }
    public void clear() {
        data.clear();
    }
}
