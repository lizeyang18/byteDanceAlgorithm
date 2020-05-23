package byteDance;

import java.util.Stack;

/**
 * Created by lizeyang on 2020/5/15.
 * 两个栈实现一个队列,so easy~
 */
public class test35 {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void offer(int num) {
        stack1.push(num);
    }

    public static int poll() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        int res =  stack2.pop();
        swap(stack1,stack2);
        return res;
    }
    public static void swap(Stack<Integer> stack1,Stack<Integer> stack2){
        Stack<Integer> tmp = stack1;
        stack2 = stack2;
        stack2 = tmp;
    }

    public static int peek() {
        int res = 0;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        res = stack2.peek();
        swap(stack1,stack2);
        return res;
    }

    public static void main(String[] args) {
        offer(1);
        offer(2);
        System.out.println(poll());
        offer(3);
        System.out.println(peek());
        System.out.println(poll());
    }
}
