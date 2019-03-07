package ReplaceText;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "E:\\IdeaProjects\\homeWork\\src\\test";

        File file = new File(filePath);
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        for (File each:files) {
            try {
                rewrite(each);
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }

    public static void rewrite(File file) throws IOException {
        File tmp = File.createTempFile("tmp", null);

        try(Scanner input = new Scanner(file);
            PrintWriter output = new PrintWriter(tmp);
        ){
            while (input.hasNext()) {
                String data = input.nextLine();

                String[] x = data.split("Exercise");
                String newData = "";
                for(int i = 0;i < x.length;i++) {
                    System.out.println(x[i]);
                    if(x[i].length() >= 3 && i != 0) {
                        if (!((int) (x[i].charAt(1)) >= 48 && (int) (x[i].charAt(1)) <= 57)) {
                            x[i] = "0" + x[i];
                        }
                        if (!(x[i].length()>= 5 &&(int) (x[i].charAt(4)) >= 48 && (int) (x[i].charAt(4)) <= 57)) {
                            x[i] = x[i].substring(0, 3) + "0" + x[i].substring(3);
                        }
                        newData += "Exercise" + x[i];
                    }
                    else if(i == 0) {
                        newData += x[i];
                    }
                }
                output.println(newData);
            }
        }

        try(Scanner input = new Scanner(tmp);
            PrintWriter output = new PrintWriter(file);
        ){
            while (input.hasNext()) {
                output.println(input.nextLine());
            }
        }

    }
}
