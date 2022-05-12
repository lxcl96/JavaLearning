package chapter_19_IO_.HomeWork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/4/3
 * @Description :   (1)判断此目录下是否有mytemp文件夹，如果没有就创建mytemp
 *                  （2）在mytemp目录下创建文件hello.txt
 *                  （3）如果hello.txt存在就提示 文件已经存在，不要重复创建了
 *                  （4）并在文件中，写入hello,world
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\mytemp";
        String fileName = "hello.txt";
        File filepath = new File(filePath);
        File filename = new File(filePath + File.separator + fileName);
        if (!filepath.exists()) {//如果此目录不存在，创建
            filepath.mkdirs();//最好判断有没有创建成功
        }

        if (filename.exists()) {
            System.out.println("文件已经存在");
            return;
        }
        if (!filename.createNewFile()) {
            System.out.println("文件创建失败请检查！");
        }
        FileWriter fileWriter = new FileWriter(filePath + File.separator + fileName);
        fileWriter.write("hello,world");

        fileWriter.close();
        System.out.println("文件目录创建成功！");

    }
}
