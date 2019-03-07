package WebReptile;


import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String startingURL = "https://www.bilibili.com/";
        String aimString = "B站";
        int maxFinding = 10000;

//        Scanner input = new Scanner(System.in);
//
//        System.out.print("请输入开始网址："); startingURL = input.nextLine();
//        System.out.print("请输入目标文本："); aimString = input.nextLine();
//        System.out.print("请输入最大检索次数："); maxFinding = input.nextInt();

        if(crawler(startingURL,aimString,maxFinding))
            System.out.println("找到了！");
        else
            System.out.println("没有找到！");
    }

    public static boolean crawler(String startingURL,String aimString,int maxFinding) {
        //打印开始信息：
        System.out.println("开始网址：" + startingURL);
        System.out.println("目标内容：" + aimString);
        System.out.println();

        ArrayList<String> findedURL = new ArrayList<>();
        ArrayList<String> needFindingURL = new ArrayList<>();
        needFindingURL.add(startingURL);

        findedURL.add(startingURL);
        while (findedURL.size() <= maxFinding && !needFindingURL.isEmpty()) {
            try {
                URL url = new URL(needFindingURL.remove(0));
                Scanner input = new Scanner(url.openStream());
                int current = 0;

                while (input.hasNext()) {
                    String line = input.nextLine();

                    //如果已经找到
                    if(line.contains(aimString)) {
                        System.out.println("目标网址：" + url.toURI());
                        System.out.println("内容来源：" + line);
                        return true;
                    }

                    current = line.indexOf("http:",current);
                    while (current > 0) {
                        int endIndex = line.indexOf("\\",current);
                        if(endIndex > 0) {
                            needFindingURL.add(line.substring(current,endIndex));
                            current = line .indexOf("https:",endIndex);
                        }
                        else
                            current = -1;
                    }
                }

            }catch (Exception ex) {
                System.out.println("发生错误：" + ex.getMessage());
            }
        }
        return false;
    }
}
