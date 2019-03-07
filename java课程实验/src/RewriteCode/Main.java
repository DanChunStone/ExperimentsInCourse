package RewriteCode;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String sourceFilePath = "E:\\IdeaProjects\\homeWork\\src\\x.java";
        String targetFilePath = "E:\\IdeaProjects\\homeWork\\src\\y.java";

        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        if(!sourceFile.exists()||targetFile.exists()) {
            System.out.println("源文件不存在或者目标文件已经存在！");
            System.exit(3);
        }

        try(
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(targetFile);
                ) {
            String s1 = input.nextLine();
            while (input.hasNext()) {
                String s2 = input.nextLine();

                if(s2.charAt(s2.length()-1)=='{'){
                    output.println(s1+" {");
                    s1 = input.nextLine();
                }
                else {
                    output.println(s1);
                    s1 = s2;
                }
            }
            output.println(s1);
        }


    }
}
