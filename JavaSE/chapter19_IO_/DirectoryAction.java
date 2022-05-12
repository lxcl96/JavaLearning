package chapter_19_IO_;

import org.junit.Test;

import java.io.File;

/**
 * @Author : Ly
 * @Date : 2022/3/31
 * @Description : 目录操作[目录不区分大小写]
 */

public class DirectoryAction {
    public static void main(String[] args) {
        //判断example_下news1.txt 是否存在，如果存在就删除
        String fileName = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\example_/news1.txt";
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete())//此函数可以删除文件或目录
                System.out.println("文件存在，已经删除");
        } else {
            System.out.println(fileName + "不存在！");
        }

    }

    @Test
    public void deleteDirectory() {
        //判断test目录 是否存在，如果存在就删除 [目录也被当作文件，只能删除空目录]
        String directory = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\Test\\";
        File file1 = new File(directory);
        if (file1.exists()) {
            if (file1.delete()) {//此函数可以删除文件或目录
                System.out.println("文件存在，已经删除");
            }
            else {
                System.out.println("删除失败" );
            }
        } else {
            System.out.println(directory + "不存在！");
        }
    }


    @Test
    public void createDirectory() {
        //判断 test\\a\\b\\c 目录 是否存在，如果存在就删除 就提示存在否则就创建
        // 注意同dos命令一样： mkdir()只创建一个目录，如果中间存在未创建的目录，就会报错
        //                  mkdirs()连续创建目录
        String directory = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\Test\\a\\b\\c";
        String directory2 = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\Test\\a\\";//成功
        //String directory2 = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\Test\\a\\b\\c\\";//失败
        File file = new File(directory2);
        if (file.exists()) {
                System.out.println(directory2 + "目录存在");
        } else {
            if (file.mkdir()) {
                System.out.println("创建成功！");
            }else {
                System.out.println("创建失败!");
            }
        }
    }
}

