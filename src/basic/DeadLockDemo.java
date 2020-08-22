package basic;

/**
 * 死锁：线程1持有线程2需要的资源，同时线程2持有线程1需要的资源
 * 产生死锁的条件：
 * 1.互斥条件：该资源任意一个时刻只由一个线程占有
 * 2.请求与保持条件：一个线程因请求资源而阻塞，并对持有的资源不释放
 * 3.不剥夺条件：线程在已获得资源未使用完不被其他资源强行剥夺，只有自己完成后才释放资源
 * 4.循环等待条件：若干线程形成一个循环等待资源释放的关系。
 * 如何避免死锁：
 * 1.一次性申请所有需要的资源
 * 2.占用资源的线程在进一步请求其他资源失败后释放自己所持有的资源
 * 3.按顺序申请资源。按指定顺序申请资源，释放资源则按反序。破坏循环等待条件。
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread()+"resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"wait resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"resource2");
                }
            }
        },"线程1").start();

//        new Thread(()->{
//            synchronized (resource2){
//                System.out.println(Thread.currentThread()+"resource2");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread()+"wait resource1");
//                synchronized (resource1){
//                    System.out.println(Thread.currentThread()+"resource1");
//                }
//            }
//        },"线程2").start();
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread()+"resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"wait resource1");
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"resource1");
                }
            }
        },"线程2").start();
    }
}
