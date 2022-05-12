package chapter17_Muti_Threads.ThreadMethods;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description :
 */
public class Method {
}
/*
    常用方法：
    1、seName 设置线程名称，使之与name参数相同
    2、getName 返回线程的名称
    3、start 使该线程启动，多线程真正原因是jvm调用start0方法
    4、run 调用线程对象run方法
    5、setPriority 修改线程优先级
    6、getPriority 获取线程优先级
    7、sleep 线程休眠
    8、interrupt //线程中断 但是并没有真正的结束线程 所以一般用于中断正在休眠线程,
        一般会用try-catch捕获处理，所以线程并没有中断

    9、yield：线程的礼让。让出cpu让其他线程先执行，但是礼让时间不确定，所以不一定会礼让成功
     【在t1中调用t1.yield方法，此方法为静态方法】
        【如：cpu资源充足就不会礼让成功】
    10、join：线程的插队，插队的线程一旦插队成功，则肯定先执行完插入的线程的所有任务，再执行之前的线程
     【在线程t1内部，调用线程t2.join()】
      例子：main创建一个子线程，每隔１ｓ输出ｈｅｌｌｏ，输出20次，主线程每隔1s，输出hi，输出20次
      要求两个线程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续。
 */