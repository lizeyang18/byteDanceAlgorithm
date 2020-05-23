package byteDance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lizeyang on 2020/5/15.
 * 输出给定数字下一个比它大的数字，比如输入：1234， 输出 1243
 */
public class test33 {
    //利用全排列，bfs实现
    public static int test(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        List<String> list = new ArrayList<>();
        partition(chars, 0, list);
        Collections.sort(list);
        if (list.get(list.size() - 1).equals(String.valueOf(num))) {
            return -1;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(String.valueOf(num))) {
                    return Integer.valueOf(list.get(i + 1));
                }
            }
        }
        return -1;
    }

    public static void partition(char[] chars, int index, List<String> list) {
        if (index == chars.length - 1) {
            String str = String.valueOf(chars);
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        for (int j = index; j < chars.length; j++) {
            swap(chars, index, j);
            partition(chars, index + 1, list);
            swap(chars, j, index);
        }
    }

    public static void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public static void main(String[] args) {
        int num = 1234;
        System.out.println(test(num));
    }
}
