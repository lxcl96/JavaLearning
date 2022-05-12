## JSON

***JavaScript中使用JSON：***

1. json是由键值对组成的，并且由大括号包围。每个键由花括号引起来，键和值之间使用冒号分割。多组键值对之间使用逗号分割。

   ```js
   let jsonObj = {
   				"k1":"12",
   				"k2":"13",
   				"k3":"14",
   				"k4":"15"
   			}
   ```

2. 定义json

   ```js
   let jsonObj = {
   				"k1":12,
   				"k2":"13",
   				"k3":true,
   				"k4":[11,"aa",true],
   				"k5": { //json
   					"k51":1,
   					"k52":"2"
   				},
   				"k6":obj, //js对象
   				"k7":[ //json数据
   					{"k":"v"},
   					{"k1":"v1"},
   					{"k2":"v2"}
   				]
   			}
   ```

3. json的访问

   json本身就是一个对象，所以可以把json 中的key当作对象的属性，而其对应的value就是属性的值

   ```js
   jsonObj.k1;
   ```

4. json转字符串

   ```js
   //将json对象转化为json字符串 [一般在：服务器和客户端进行数据交换时]
   let jsonStr = JSON.stringify(jsonObj);
   //将json字符串转化为json对象 [一般在：修改json数据值时]
   JSON.parse(jsonStr);
   ```

***[Java中使用JSON](../16_json/src/com/ly/json)：***

需要先导入json的jar包

1. [`javaBean和json的相互转化`](../16_json/src/com/ly/json)

   ```java
   Person person = new Person(1,"hsp");
           Gson gson = new Gson();
           //JavaBean转化为json字符串
           String personJsonStr = gson.toJson(person);
           System.out.println(personJsonStr);
   
           //json字符串转化为JavaBean ，第二参数为class是转化成一个对象使用的，如果是集合多个对象 需要使用type参数
           Person personBean = gson.fromJson(personJsonStr, person.getClass());
           System.out.println(personBean);
   ```

2. [`List和json的相互转化`](../16_json/src/com/ly/json)

   ```java
   ArrayList<Person> strList = new ArrayList<>();
           strList.add(new Person(1,"hsp"));
           strList.add(new Person(2,"ly"));
           System.out.println(strList);
   
           Gson gson = new Gson();
           String strListJsonStr = gson.toJson(strList);
           System.out.println(strListJsonStr);
           //json字符串转化为List集合 使用person.getClass()无法转化为Person类型
           //需要用到 gson中的反射类 TypeToken 
           /*
               做法如下：
               1、新建一个类 继承gson中的TypeToken类如PersonListType 并指定该类泛型为 要转换的类型 即 ArrayList<Person>
               2、调用fromJson()方法，其中第二个参数为 new PersonListType().getType()
            */
           //ArrayList<Person> arrayList = gson.fromJson(strListJsonStr, strList.getClass());
           ArrayList<Person> arrayList = gson.fromJson(strListJsonStr, new PersonListType().getType());
           Person person = arrayList.get(0);
           System.out.println(arrayList);
   ```

3. [`map和json的相互转化`](../16_json/src/com/ly/json)

   ```java
   HashMap<String, Person> hashMap = new HashMap<>();
           hashMap.put("1",new Person(1,"hsp"));
           hashMap.put("2",new Person(2,"ly"));
           System.out.println(hashMap);
   
           Gson gson = new Gson();
           String s = gson.toJson(hashMap);
           System.out.println(s);
   
           //map转换成json 方法和List的一样
           //HashMap hashMap1 = gson.fromJson(s, hashMap.getClass());
           //内部类  class Type extends TypeToken<HashMap<String,Person>> {}
           
           //匿名内部类 new 接口()/类() {}.方法()
           HashMap hashMap1 = gson.fromJson(s, new TypeToken<HashMap<String,Person>>() {}.getType());
           System.out.println(hashMap1);
   ```

