package chapter15_Generics_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GenericsExercise {
    public static void main(String[] args) {
        Student tom = new Student("tom");
        Student jack = new Student("jack");
        Student marry = new Student("marry");
        HashMap<String, Student> map = new HashMap<>();
        map.put(tom.getName(), tom);
        map.put(jack.getName(), jack);
        map.put(marry.getName(), marry);
        System.out.println(map);


        //遍历1
        Collection<Student> values = map.values();
        for (Student s: values) {
            System.out.println(s.getName());
        }

        //遍历2
        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
