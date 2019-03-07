public class Main {
    public static void main(String[] args){
        //可分配资源矩阵
        int[] x = {3,3,2};
        //进程最大资源需求矩阵
        int[][] y = {{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};
        //进程已分配资源矩阵
        int[][] z = {{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};

        Banker banker = new Banker();
        banker.init(x,y,z);

        banker.run();

    }
}
