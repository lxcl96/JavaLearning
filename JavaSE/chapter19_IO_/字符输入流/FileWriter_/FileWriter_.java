package chapter_19_IO_.字符输入流.FileWriter_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/4/1
 * @Description : 将“风雨之后，必见彩虹”写入到note.txt中
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字符输入流\\FileWriter_";
        String fileName = "note.txt";
        String file = filePath + "\\" + fileName;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("风雨之后，必见彩虹");
            System.out.println("写入成功！");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                System.out.println(fileWriter.getEncoding());
                fileWriter.flush(); //FileWriter必须要flush或者close 否则无法保存
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
