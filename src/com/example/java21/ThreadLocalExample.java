package com.example.java21;

public class ThreadLocalExample {
    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->0);

    public static void main(String[] args) {
        Runnable task1 = ()->{
            int value = threadLocal.get();
            threadLocal.set(++value);
            System.out.println(Thread.currentThread().getName()+" -> "+value);
        };

        Thread thread1 = new Thread(task1,"Thread-1");
        Thread thread2 = new Thread(task1,"Thread-2");

        thread1.start();
        thread2.start();
    }
}
