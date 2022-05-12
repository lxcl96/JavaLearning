package chapter_19_IO_;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author : Ly
 * @Date : 2022/3/31
 * @Description : 在example_包下创建文件 news1.txt news2.txt  news3.txt使用三种不同的方法（构造器）
 */
public class FileCreate {
    public static void main(String[] args) {
        create01();//new File(fileName)  --String
        create02();//new File(FilePath, fileName); --File,String
        create03();//new File(parentFile, fileName); --String,String
    }

    //方式1 根据全路径创建
    public static void create01() {
        String fileName= "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\example_/news1.txt";
        File file = new File(fileName);//此时文件已经在内存中创建
        try {
            file.createNewFile();//将内存的文件写入磁盘
            System.out.println("文件创建成功！1");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    //方式2 根据目录(String)+文件名(String)分开的方式创建
    public static void create02() {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\example_\\";
        String fileName = "news2.txt";
        //也可以这样  这种就是拼接
        String filePath1 = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\";
        String fileName2 = "example_\\news2.txt";
        try {
            File file = new File(filePath, fileName);
            file.createNewFile();
            System.out.println("文件创建成功！2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式3 根据父目录(File)+文件名（String）分开的方式创建
    public static void create03() {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\example_\\";
        String fileName = "news3.txt";
        try {
            File parentFile = new File(filePath);//创建父级目录
            //传入父级目录，创建文件
            File file = new File(parentFile, fileName);

            file.createNewFile();
            System.out.println("文件创建成功！3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
