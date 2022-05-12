package chapter09_HouseRentSys.view;


import chapter09_HouseRentSys.domain.House;
import chapter09_HouseRentSys.service.HouseService;
import chapter09_HouseRentSys.utils.Utility;

/*
 * 1、显示界面
 * 2、接收用户输入
 * 3、调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;//控制显示菜单
    public char key = ' ';//接收用户选择
    //创建房屋 放在外面
    private HouseService houseService = new HouseService(10);
    //显示主界面
    public void mainMenu() {
        do {
            System.out.println("-----------------房屋出租系统-----------------");
            System.out.println("             1 新 增 房 源");
            System.out.println("             2 查 找 房 屋");
            System.out.println("             3 删 除 房 屋");
            System.out.println("             4 修 改 房 屋 信 息");
            System.out.println("             5 房 屋 列 表");
            System.out.println("             6 退      出");
            System.out.print("请选择(1-6)：");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    HouseAdd();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    HouseList();
                    break;
                case '6':
                    loop = quit();
                    break;
                default:
                    System.out.println("输入有无！");
            }

        } while (loop);
    }
    //修改房屋信息：
    public void updateHouse() {
        System.out.println("-----------------修改客户-----------------");
        System.out.print("请选择待修改房屋编号(-1退出)：");
        int id = Utility.readInt();
        House house = houseService.checkHouse(id);
        //如果有这个房子
        if(house != null) {
            //如果回车默认不修改
            System.out.print("姓名(" + house.getName() +")：");
            String name = Utility.readString(5, "");//name
            System.out.print("电话(" + house.getPhone() + ")：");
            String phone = Utility.readString(11, "");//phone
            System.out.print("地址(" + house.getAddress() + ")：");
            String address = Utility.readString(24, "");//address
            System.out.print("月租(" + house.getRent() + ")：");
            int rent = Utility.readInt(-1);//rent
            System.out.print("状态(" + house.getState() + ")：");
            String state = Utility.readString(3, "");//state
            houseService.update(house, name, phone, address, rent, state);
            System.out.println("-----------------修改成功-----------------");
            return;
        }
        System.out.println("---------------修改失败，没有此房屋！--------------");
    }
    //查找房屋
    public void findHouse() {
        System.out.println("-----------------查找房屋-----------------");
        System.out.print("请输入你要查找的id：");
        int id = Utility.readInt();
        houseService.findById(id);
    }
    //退出系统
    public boolean quit() {
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {
            System.out.println("-----------------退出系统-----------------");
            return false;
        }
        return true;
    }
    //删除房屋
    public void delHouse() {
        System.out.println("-----------------删除房屋-----------------");
        System.out.print("请选择待删除房屋编号(-1退出)：");
        int number = Utility.readInt(-1);
        if (number == -1) return;
        System.out.println("确认是否删除(Y/N)：请小心选择：");
        System.out.println("请输入你的选择(Y/N)：");
        char confirm = Utility.readChar('N');
        if (confirm == 'Y') {
            boolean flag = houseService.del(number);
            if (flag)
                System.out.println("----------------删除完成------------------");
            else
                System.out.println("----------------删除失败------------------");
        }
        System.out.println("退出删除界面。。。");
    }


    //HouseList显示房屋列表
    public void HouseList() {
        System.out.println("----------------房屋列表------------------");
        //放在指定的位置 有序
        House[] houses = houseService.list();
        System.out.println("编号" + "\t\t" + "房主" + "\t\t" + "电话" + "\t\t" + "地址" + "\t\t" +
                "月租" + "\t\t" + "状态(未出租/已出租)");

//        for (int i = 0; i < houses.length; i++) {
//            System.out.println(houses[i]);
//        }
        //改进
        for (House house : houses) {
            if (house != null)
                System.out.println(house);
        }

        System.out.println("--------------房屋列表完成-----------------");
    }

    //HouseAdd  添加房屋
    public void HouseAdd() {
        System.out.println("----------------添加房屋------------------");
        System.out.println("退出租房系统");
        System.out.print("姓名：");
        String name = Utility.readString(5);//name
        System.out.print("电话：");
        String phone = Utility.readString(11);//phone
        System.out.print("地址：");
        String address = Utility.readString(24);//address
        System.out.print("月租：");
        int rent = Utility.readInt(3000);//rent
        System.out.print("状态(未出租/已出租)：");
        String state = Utility.readString(3);//state

        boolean flag = houseService.add(name, phone, address, rent, state);
        if (flag)
            System.out.println("----------------添加完成------------------");
        else
            System.out.println("----------------添加失败------------------");
    }
}
