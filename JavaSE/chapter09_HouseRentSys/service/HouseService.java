package chapter09_HouseRentSys.service;


import chapter09_HouseRentSys.domain.House;

/**
 * HouseService.java《=》类 【业务层】
 * 定义House[] ,保存House对象
 * 1、响应HouseView的调用
 * 2、完成对房屋信息的各种操作【增删改查crud】
 * create/read/update/delete
 */
public class HouseService {
    private House[] houses;//存放House对象

    public HouseService(int size) {
        this.houses = new House[size];//初始化时开辟空间
        houses[0] = new House(1, "jack", "112", "海淀区", 2000, "未出租");
    }

    //list方法返回house数组
    public House[] list() {
        return houses;
    }

    //add方法 进行房屋添加  汉字都在view 改一下把
    public boolean add(String name, String phone, String address, int rent, String state) {
        //如果已满，退出
        if (houses[houses.length - 1] != null) {
            System.out.println("数组已满，无法继续添加。请联系管理员。。。");
            return false;
        }
        int index = -1;
        //顺序增加房源 判断最大值
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                index = i;
                break;
            }
        }
        //设置属性 因为需要 new House()否则会报空指针异常
        houses[index] = new House();
        //赋值
        houses[index].setId(index + 1);//id
        houses[index].setName(name);//name
        houses[index].setPhone(phone);//phone
        houses[index].setAddress(address);//address
        houses[index].setRent(rent);//rent
        houses[index].setState(state);//state
        return true;
    }

    //del方法，删除指定编号
    public boolean del(int number) {
        boolean flag = false;
        if (number < 1 || number >= houses.length) {
            System.out.println("房屋编号不正确");
            return false;
        }
        if (houses[number - 1] == null) {
            System.out.println("该编号房屋不存在");
            return false;
        }
        //需要考虑删除的时位置 第一个怎么办？ 中间的怎么办？最后一个怎么办？循环来吧  老师的方法 要改全改
        //就不能用长度来判断了
//        for (int i = 0; i < houses.length; i++) {
//            if(number == houses[i].getId()) {
//                flag = true;
//                continue; //去到覆盖的下一位
//            }
//
//            //有就 覆盖
//            if (flag) {
//                houses[i - 1] = houses[i];
//            }
//
//        }
//        houses[houses.length - 1] = null;
        houses[number - 1] = null;
        return true;
    }

    //findById方法
    public void findById(int id) {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {
                if (houses[i].getId() == id) {
                    System.out.println(houses[i]);
                    return;
                }
            }
        }
        System.out.println("没有该房屋");
    }

    //checkHouse 房屋校验
    public House checkHouse(int id) {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {
                if (houses[i].getId() == id) {
                    return houses[i];//有这个编号的id
                }
            }
        }
        return null;//没有这个编号的id
    }

    //update 更新房源信息
    public void update(House house, String name, String phone, String address, int rent, String state) {
        house.setName(name);
        house.setPhone(phone);
        house.setAddress(address);
        house.setRent(rent);
        house.setState(state);
    }
}


