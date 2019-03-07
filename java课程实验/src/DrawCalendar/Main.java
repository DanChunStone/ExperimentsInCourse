package DrawCalendar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入你需要打印的年份(1900-now):");
        int year = input.nextInt();

        if(year >= 1900) {
            Drawing(year);
        }
        else
            System.out.print("输入有误！");
    }


    //打印日历
    public static void Drawing(int year) {
        for (int i = 0; i < 4; i++) {
            String[][] Title = new String[3][];
            String[][] Subject = new String[3][];

            Title[0] = drawTitle(year,3*i+1);
            Title[1] = drawTitle(year,3*i+2);
            Title[2] = drawTitle(year,3*i+3);

            Subject[0] = drawSubject(year,3*i+1);
            Subject[1] = drawSubject(year,3*i+2);
            Subject[2] = drawSubject(year,3*i+3);

            for (int j = 0;j < 3;j++) {
                System.out.print(Title[0][j]);
                System.out.print("     ");
                System.out.print(Title[1][j]);
                System.out.print("     ");
                System.out.print(Title[2][j]);
                System.out.println();
            }
            for (int j = 0;j < 6;j++) {
                if(Subject[0].length > j)
                    System.out.print(Subject[0][j]);
                else
                    System.out.print("                                       ");
                System.out.print("     ");
                if(Subject[1].length > j)
                    System.out.print(Subject[1][j]);
                else
                    System.out.print("                                       ");
                System.out.print("     ");
                if(Subject[2].length > j)
                    System.out.print(Subject[2][j]);
                else
                    System.out.print("                                       ");
                System.out.println();
            }
        }
    }


    //打印标题栏
    public static String[] drawTitle(int year,int month) {
        //用以记录月份单词
        final String[] MONATH = {"Janunary","February","March","April","May","June","July",
                "August","September","October","November","December"};

        //用以记录星期单词缩写
        final String[] WEEKDAY = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

        String result[] = {"","",""};

        String x = MONATH[month - 1] + " " + year;

        System.out.println();

        //打印月份与年份
        for(int i = 0;i < (39 - x.length()) / 2;i++) {
            result[0] += " ";
        }
        result[0] += x;
        for(int i = 0;i < 39 - result[0].length();i++)
            result[0] += " ";

        //打印横线
        result[1] = "---------------------------------------";

        //打印星期栏
        for(int i = 0;i < 7;i++) {
            if(i != 0)
                result[2] += "   ";

            result[2] += WEEKDAY[i];
        }
        //在长度不够39的字符串末尾加空格
        for(int i = 0;i < result.length;i++) {
            int len = 39 - result[i].length();
            for(int j = 0;j < len;j++)
                result[i] += " ";
        }
        return result;
    }


    //打印日历主体
    public static String[] drawSubject(int year,int month) {
        int[] day = {31,28,31,30,31,30,31,31,30,31,30,31};
        int totalDay = 0;

        for(int i = 1900;i < year;i++) {
            if((i % 4 == 0 && i % 100 != 0)||(i % 400 == 0))
                totalDay += 1;
            totalDay += 365;
        }
        for(int i = 0;i < month - 1;i++)
            totalDay += day[i];

        int currentWeek = totalDay % 7;

        int j = day[month - 1] + currentWeek;
        String[] result = new String[j % 7 == 0 ? j / 7 : j / 7 + 1];
        for (int i = 0;i < result.length;i++)
            result[i] = "";
        int oy = 0;
        for(int i = 0;i < j;i++) {
            if(i % 7 != 0)
                result[oy] += "   ";

            if(i < currentWeek)
                result[oy] += "   ";
            else
                result[oy] += String.format("%3d",i + 1 - currentWeek);

            if(i % 7 == 6)
                oy++;
        }

        //在长度不够39的字符串末尾加空格
        for(int i = 0;i < result.length;i++) {
            int len = 39 - result[i].length();
            for(int k = 0;k < len;k++)
                result[i] += " ";
        }
        return result;
    }
}
