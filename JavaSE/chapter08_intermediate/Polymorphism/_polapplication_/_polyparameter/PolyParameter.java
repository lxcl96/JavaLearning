package chapter08_intermediate.Polymorphism._polapplication_._polyparameter;

public class PolyParameter {
    public static void showEmpAnnual(Employee e){
        //方法形参为 父类类型，实参为 子类类型
        System.out.println(e.getName() + "的年工资为：" + e.getAnnual());
    }

    public static void testWork(Employee e){
        if (e instanceof normalEmployee)
            ((normalEmployee) e).work();
        if (e instanceof Manager)
            ((Manager) e).manage();
    }
    public static void main(String[] args) {
        normalEmployee nor = new normalEmployee("小王", 2000);
        showEmpAnnual(nor);
        //必须要加上static  因为不加的话 静态方法调用非静态方法 需要新创建 new PolyParameter的方式来调用
        Manager 刘总 = new Manager("刘总", 30000, 200000);
        showEmpAnnual(刘总);

        testWork(nor);
        testWork(刘总);


    }
}
