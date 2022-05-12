package chapter15_Generics_;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class HomeWork01 {
    @Test
    public static void main(String[] args) {
        User lh = new User(1001, 25, "李华");
        User ll = new User(1002, 27, "李雷");
        User hmm = new User(1003, 26, "韩梅梅");
        DAO<User> u = new DAO<>();
        u.save(lh.getName(), lh);
        u.save(ll.getName(), ll);
        u.save(hmm.getName(), hmm);
        System.out.println(u.map);

        System.out.println(u.get("李华"));
        System.out.println(u.get("李雷"));
        System.out.println(u.get("韩梅梅"));

        u.save(lh.getName(), lh);
        u.save(ll.getName(), hmm);
        u.save(hmm.getName(), ll);

        System.out.println(u.list());
        System.out.println(u.map);

        u.delete("李华");

        System.out.println(u.map);


    }

}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class DAO<T> {
    //只建立引用没存上啊喂
//    HashMap<String, T> map;
    HashMap<String, T> map = new HashMap<>();
    public void save(String id, T entity) {
        map.put(id, entity);
    }
    public T get(String id) {
        return map.get(id);
    }
    //?
    public void update(String id, T entity) {
        map.put(id, entity);
    }
    public List<T> list(){
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t: values) {
            list.add(t);
        }
        return list;
    }
    public void delete(String id) {
        map.remove(id);
    }

}