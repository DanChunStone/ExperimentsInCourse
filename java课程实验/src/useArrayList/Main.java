package useArrayList;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();

        Date date = new Date();
        String string = "今年是2018年";
        Circle circle = new Circle(5);

        list.add(date);
        list.add(string);
        list.add(circle);

        for (Object each : list) {
            System.out.println(each.toString());
        }
    }

    static class Circle extends Object{
        private int radius;

        public Circle() {radius = 0;}
        public Circle(int radius) {this.radius = radius;}

        public String toString() {
            return "该圆形的半径为：" + radius;
        }
    }
}
