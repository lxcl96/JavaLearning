package chapter_19_IO_.转换流;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description :
 */
public class tips {
}

/*
    转换流，可以使得 字节流和字符流 相互转换
    比如：解决乱码类型 CodeQuestion

    InputStreamReader 和 OutputStreamReader 介绍【都是包装流】：
    1、InputStreamReader 是Reader的子类，可以将InputStream字节输入流包装成Reader字符输入流
    2、OutputStreamReader 是Writer的子类，可以将OutputStream字节输出流包装成Writer字符输出流
    3、当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文乱码问题，建议使用
    4、可以在使用时指定文件编码格式如utf8 gbk gb2312 ISO8859-1
 */
