package chapter_19_IO_;

import java.io.File;

/**
 * @Author : Ly
 * @Date : 2022/3/31
 * @Description : 常用的文件操作
 */
public class FileCommAction {
    public static void main(String[] args) {
        String fileName = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\FileCreate.java";
        File file = new File(fileName);
        System.out.println("是否为文件" + file.isFile());
        System.out.println("文件名" + file.getName());
        System.out.println("文件绝对路径" + file.getAbsolutePath());//返回类型 String
        System.out.println("文件绝对路径名" + file.getAbsoluteFile());//返回类型 File
        System.out.println("文件的父级目录" + file.getParent());
        System.out.println("文件的大小" + file.length());//单位字节
        System.out.println("文件是否存在" + file.exists());
        System.out.println("是否是个目录" + file.isDirectory());




    }

}
