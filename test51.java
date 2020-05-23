package byteDance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:lizeyang
 * @Date:2020/5/23 11:10
 * function:手写jdk中的优先级队列 PriorityQueue(最小堆)
 */
public class test51 {
    private static List<Integer> list = new ArrayList<>();

    /**
     * 添加元素：建立最大堆的过程
     *
     * @param data
     */
    public static void add(int data) {
        list.add(data);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int index = i;
            while (list.get(index) > list.get((index - 1) / 2)) {
                //父子交换
                swap(list, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }
        swap(list,0,--size);
        //重新排序
        while (size > 0) {
            heapify(list, 0, size);
            swap(list, 0, --size);
        }
    }

    /**
     * 取出元素：取出优先级最高的元素（堆顶元素）
     *
     * @return
     */
    public static int poll() {
        if (list.size() == 0) {
            return 0;
        }
        int res = list.remove(list.size()-1);
        return res;
    }

    public static void swap(List<Integer> list, int a, int b) {
        int tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }

    public static void heapify(List<Integer> list, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int maxNum = left + 1 < size && list.get(left + 1) > list.get(left) ? left + 1 : left;
            maxNum = list.get(maxNum) > list.get(index) ? maxNum : index;
            if (maxNum == index) {
                break;
            }
            int tmp = list.get(index);
            list.set(index, list.get(left));
            list.set(maxNum, tmp);
            index = maxNum;
            left = index * 2 + 1;
        }
    }

    public static int peek() {
        int res = list.get(list.size()-1);
        return res;
    }

    public static void main(String[] args) {
        add(1);
        add(3);
        add(2);
        add(5);
        add(4);
        System.out.println(poll());
        System.out.println(poll());
        add(8);
        add(9);
        System.out.println(peek());
        System.out.println(poll());
    }
}
