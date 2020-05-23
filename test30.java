package byteDance;

import java.util.Stack;

/**
 * Created by lizeyang on 2020/5/15.
 * 最大栈
 */
public class test30 {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void push(int num) {
        if (stack1.isEmpty()) {
            stack1.push(num);
            stack2.push(num);
        } else {
            int tmp = stack2.peek();
            if (num > tmp) {
                stack2.push(num);
            } else {
                stack2.push(tmp);
            }
            stack1.push(num);
        }
    }

    public static int pop() {
        int res = stack1.pop();
        stack2.pop();
        return res;
    }

    public static int getMax() {
        int res = 0;
        if (!stack2.isEmpty()) {
            res = stack2.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        System.out.println(getMax());
        System.out.println(pop());
    }
}
