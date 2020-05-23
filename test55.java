package byteDance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:lizeyang
 * @Date:2020/5/23 17:13
 * function:LRU实现，美团面试耻辱！！！
 */
public class test55 {
    //方法一：LinkedhashMap实现
    int capacity;
    Map<Integer, Integer> map;

    test55(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>();
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.remove(key);
        map.put(key, value);
        return value;
    }

    public static void main(String[] args) {
        test55 test = new test55(3);
        test.put(1,2);
        test.put(2,3);
        test.put(3,4);
        test.put(4,5);
        System.out.println(test.get(2));
        test.put(5,6);
        System.out.println(test.get(2));
    }

    //方法二见test56
}
