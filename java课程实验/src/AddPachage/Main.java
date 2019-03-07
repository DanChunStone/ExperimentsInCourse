package AddPachage;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\danchun\\Documents\\文件\\test";
        File file = new File(path);
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        for(File f : files) {
            try{
                write("package " + f.getName() ,f.getPath());
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }

    }

    public static boolean write(String content, String path) throws IOException {
        // 1.获取路径下所有Java文件
        File file = new File(path);
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        // 2.读取Java文件，然后在第一行加上package信息
        for (File f : files) {
            //System.out.println(f.getName());
            //创建临时文件
            File tmp = File.createTempFile("tmp", null);
            FileOutputStream tmpOut = new FileOutputStream(tmp);
            FileInputStream tmpIn = new FileInputStream(tmp);

            RandomAccessFile raf = null;

            try {
                raf = new RandomAccessFile(f, "rw");
                byte[] buf = new byte[64];
                int Readed = 0;
                while ((Readed = raf.read(buf)) > 0) {
                    // 把原有内容读入临时文件
                    tmpOut.write(buf, 0, Readed);
                }
                raf.seek(0L);
                raf.write(content.getBytes());
                // 追加临时文件内容
                while ((Readed = tmpIn.read(buf)) > 0) {
                    raf.write(buf, 0, Readed);
                }
                //异常处理
            } catch (IOException e) {
                System.out.println("发生错误，未能写入");
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
