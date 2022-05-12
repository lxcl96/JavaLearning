package chapter14_Collect_.Map_;

public class tips {
}
/**
 *  1、Map和Collection并列存在，用于保存具有映射关系的数据：key-value [且是无序的]
 *  2、Map中的key和value可以是任何引用类型数据，会封装到HashMap$Node对象中【HashMap的内部类Node】
 *  3、Map中的key不允许重复，后面重复key的value会替换前面的value 【替换】
 *      【因为是根据key进行hash求值的，可以看HashSet】
 *  4、Map的value可以重复
 *  5、Map中的key和value可以为空，但是【key只能有一个为空，value可以有很多】
 *  6、Map中key和value可以存放任意Object子类
 *  7、key和value是一对一关系，指定key肯定会找到对于的value
 *  8、Map中存放数据的key-value，一对k-v是放在HashMap的Node中的，
 *
 *      【源码的Entry<K, V>这里的K就叫做set，V就叫做Collection】
 *      又因为Node实现了Entry接口，所以也会被叫做：一对k-v就是一个Entry 【Map接口的Entry接口】
 *      所以有人说key是存放在EntrySet中的，value是存放在Collection中的：
 *          key-value实际上是存放在HashMap的Node数组中的
 *          EntrySet只是指向 Node中的 key
 *          Collection只是指向 Node中的 value
 *  9、
 */