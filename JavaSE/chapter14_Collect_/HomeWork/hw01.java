package chapter14_Collect_.HomeWork;

import java.util.ArrayList;

public class hw01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new News("新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河”圣浴“引民众担忧！"));
        list.add(new News("新闻二：男子突然想起2个月前钓的鱼还在网兜中，捞起来一看抓紧放生！"));
//        System.out.println(list);
        //倒叙遍历
        for (int i = list.size() - 1; i >= 0 ; i--) {
            System.out.println(list.get(i));
        }
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        if (title.length() > 15)
            return title.substring(0 , 15) + "...";
        return title;
    }
}