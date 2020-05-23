package byteDance;

/**
 * Created by lizeyang on 2020/5/15.
 * 单例模式（懒汉模式）
 */
public class test25 {
    private static volatile test25 singleton = null;
    test25(){};
    public static test25 getInstance(test25 singleton){
        if(singleton==null){
            synchronized(test25.class){
                if(singleton==null){
                    singleton = new test25();
                }
            }
        }
        return singleton;
    }
}
