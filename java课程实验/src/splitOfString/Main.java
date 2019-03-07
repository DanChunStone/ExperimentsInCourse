package splitOfString;

public class Main {
    public static void main(String[] args) {
        String[] z = split("石立军X计算机162班Y6130116053X计算机专业Y信息工程学院","[XY]");

        for(String each : z){
            System.out.println(each);
        }
    }

    public static String[] split(String s,String regex) {
        String[] x = s.split(regex);
        String[] y = new String[x.length * 2 - 1];
        int nowIndex = 0;

        for (int i = 0; i < y.length; i++) {
            if (i % 2 == 0)
                y[i] = x[i / 2];
            else {
                nowIndex += x[i/2].length();
                y[i] = s.substring(nowIndex,nowIndex += 1);
            }
        }

        return y;
    }
}

