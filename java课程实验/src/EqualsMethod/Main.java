package EqualsMethod;

public class Main {
    public static void main(String[] args) {
        Circle x1 = new Circle(3);
        Circle x2 = new Circle(5);

        System.out.println("以下两个圆的比较结果为：");
        x1.showCircle();
        x2.showCircle();
        System.out.println("两圆" + (x1.equals(x2)?"相等":"不相等"));
    }
}

class Circle extends Object {
    private int radius;

    public Circle() {
        radius = 0;
    }
    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object obj) {
        return this.radius == ((Circle)obj).radius;
    }

    public void showCircle() {
        System.out.println("本圆形半径为：" + radius);
    }
}