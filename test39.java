package byteDance;

/**
 * Created by lizeyang on 2020/5/15.
 * 三个线程循环打印ABC
 */
public class test39 extends Thread{
    //第一种实现方式:sleep方法
    private static  int count = 0;
    public test39(String name){
        this.setName(name);
    }
    @Override
    public void run(){
        while(count<30){
            switch(count%3){
                case 0 :
                    if("A".equals(getName())){
                        printAndIncrease();
                    }
                    break;
                case 1:
                    if("B".equals(getName())){
                        printAndIncrease();
                    }
                    break;
                case 2:
                if("C".equals(getName())){
                    printAndIncrease();
                }
                break;
            }
        }
    }
    public void printAndIncrease(){
        System.out.println(getName());
        count++;
    }

    public static void main(String[] args) {
        new test39("A").start();
        new test39("B").start();
        new test39("C").start();
    }

    //第二种实现是synchronized配合wait和notifyAll，代码比较复杂，不再实现
    //第三种是lock和condition,见test40
    //第四种是使用AtomicInteger，也不再实现
}
