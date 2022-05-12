package chapter14_Collect_.Map_.Hashtable_.Properties_;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class test {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\java_work\\JavaLearing\\第一阶段Idea\\src\\chapter14_Collect_\\Map_\\Hashtable_\\Properties_\\autoagent.properties");//必须要处理异常
        properties.load(fileInputStream);
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry entry:entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
