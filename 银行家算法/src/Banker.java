import java.util.*;

public class Banker {
    //资源 j 可分配的数量
    private int[] Available;
    //Max[i][j]进程 i 需要的 j 类资源数量
    private int[][] Max;
    //Allocation[i][j]进程 i 已分配的 j 类资源数量
    private int[][] Allocation;
    //Need[i][j]进程 i 需要的 j 类资源数量
    private int[][] Need;

    private int sourceNum;
    private int pressNum;

    public Banker() {

    }

    public Banker(int n){

    }

    public void init(int[] available, int[][] max, int[][] allocation) {
        //资源数量
        sourceNum = available.length;
        //进程数量
        pressNum = max.length;

        Available = available;
        Max = max;
        Allocation = allocation;
        Need = new int[Max.length][Max[0].length];

        for (int i = 0;i < Max.length;i++)
            for (int j = 0;j < Max[0].length;j++)
                Need[i][j] = Max[i][j]-Allocation[i][j];
    }


    public void display(){
        //获取需要打印的资源种类数量
        int length = Available.length;
        //打印标题栏第一行
        String[] title = {"Max","Allo","Need","Avail"};
        for (int i = 0;i < 4;i++){
            System.out.print(i==0 ? "     ":"");
            int n = 3*length - title[i].length();
            for (int j = 0;j < (n%2==0 ? n/2 : (n-1)/2);j++)
                System.out.print(" ");
            System.out.print(title[i]);
            for (int j = 0;j < (n%2==0 ? n/2 : (n+1)/2);j++)
                System.out.print(" ");
            System.out.print("|   ");
        }
        System.out.println();

        //打印标题栏第二行
        for (int i = 0;i < 4;i++){
            System.out.print(i==0 ? "     ":"");
            for (int j = 0;j < length;j++)
                System.out.print((char)('A'+j) + "  ");
            System.out.print("|   ");
        }
        System.out.println();

        for (int i = 0;i < Max.length;i++){
            System.out.print(i<10? " P"+i+"  " : "P"+i+"  ");

            for (int j : Max[i])
                System.out.print(j + "  ");
            System.out.print("|   ");

            for (int j : Allocation[i])
                System.out.print(j + "  ");
            System.out.print("|   ");

            for (int j : Need[i])
                System.out.print(j + "  ");
            System.out.print("|   ");

            if (i == 0) {
                for (int j : Available)
                    System.out.print(j + "  ");
                System.out.print("|   ");
            }

            System.out.println();
        }
    }


    public boolean safetyCheck(){
        int[] Work = Available.clone();
        boolean[] Finish = new boolean[pressNum];

        //安全序列
        List<Integer> safetyArray = new ArrayList<>();

        for (int i=0;i<Finish.length;i++)
            Finish[i] = false;

        boolean find = true;
        do {
            int n = -1;

            //遍历进程，寻找满足条件的进程
            for (int i=0;i<pressNum;i++){
                //判断资源是否已经结束
                if (!Finish[i]){
                    find = true;
                    //判断资源是否足够该进程结束
                    for (int j = 0;j < sourceNum;j++){
                        find = find && (Need[i][j] <= Work[j]);
                    }
                    //确认资源足够
                    if (find){
                        n=i;
                        break;
                    }
                }else {
                    find=false;
                }
            }

            //找到了满足条件的进程,结束该进程并回收资源
            if(n>=0){
                Finish[n] = true;
                safetyArray.add(n);
                for (int j=0;j<sourceNum;j++){
                    Work[j] += Allocation[n][j];
                }
            }

        }while (find);

        for (boolean fi:Finish)
            if (!fi) {
                System.out.print("当前进程不安全，不予分配。 ");
                return false;
            }

        System.out.print("当前进程安全，安全序列为：[ ");
        for (Integer test:safetyArray)
            System.out.print("P"+ test +" ");
        System.out.println("]");
        return true;
    }

    public void applaySource(int index,int[] n){
        if (index<pressNum){
            //判断申请是否合法
            for (int i=0;i<sourceNum;i++){
                if (n[i]>Available[i]||n[i]>Need[index][i]){
                    System.out.println("输入有误，申请资源数大于可分配资源数或进程需要最大资源数");
                    return;
                }
            }

            //尝试分配资源
            for (int i=0;i<sourceNum;i++){
                Available[i]-=n[i];
                Allocation[index][i]+=n[i];
                Need[index][i]-=n[i];
            }
            System.out.println("尝试分配资源之后：");
            display();
            System.out.println("安全性检查：");

            if (!safetyCheck()) {
                System.out.println("申请资源失败，进程不安全。");
                for (int i=0;i<sourceNum;i++){
                    Available[i]+=n[i];
                    Allocation[index][i]-=n[i];
                    Need[index][i]+=n[i];
                }
            }

        }else {
            System.out.println("申请资源失败，进程不存在。");
        }
    }

    public void run(){
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("当前系统资源分配为：");
            display();

            System.out.println("请输入申请资源的进程号：");
            int index = input.nextInt();
            System.out.println("请输入申请的各类资源数量：");
            int[] n = new int[sourceNum];
            for (int i=0;i<sourceNum;i++)
                n[i] = input.nextInt();

            applaySource(index,n);
        }
    }
}
