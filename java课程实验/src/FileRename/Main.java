package FileRename;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("E:\\IdeaProjects\\homeWork\\src\\test.text");
        String name = "newTest";
        String filename = file.getAbsolutePath();
        if(filename.indexOf(".") >= 0)
        {
            filename = filename.substring(0,filename.lastIndexOf("."));
        }
        file.renameTo(new File(name + ".text"));   //改名
    }
}
