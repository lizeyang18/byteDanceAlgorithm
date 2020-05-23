package byteDance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lizeyang on 2020/5/15.
 * 循环打印ABC，使用lock和condition实现,为了显示方便，只循环打印10次
 */

public class test40 {
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    private char currentThreadName = 'A';

    class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (currentThreadName != 'A') {
                        try {
                            conditionA.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    currentThreadName = 'B';
                    conditionB.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class ThreadB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (currentThreadName != 'B') {
                        try {
                            conditionB.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    currentThreadName = 'C';
                    conditionC.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class ThreadC implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (currentThreadName != 'C') {
                        try {
                            conditionC.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    currentThreadName = 'A';
                    conditionA.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        test40 test40 = new test40();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(test40.new ThreadA());
        service.execute(test40.new ThreadB());
        service.execute(test40.new ThreadC());
        service.shutdown();
    }
}

