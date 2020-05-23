package byteDance;

/**
 * @Author:lizeyang
 * @Date:2020/5/23 10:49
 * function:链表实现一个栈
 */
public class test50 {
    static ListNode top;
    public static void put(int data){
        if(top==null){
           top = new ListNode(data);
        }else{
            //头插法
            ListNode node = new ListNode(data);
            node.next = top;
            top= node;
        }
    }
    public static int get(){
        int res = 0;
        if(top!=null){
            res = top.val;
            top = top.next;
        }
        return res;
    }
    public static int peek(){
        int res = 0;
        if(top!=null){
            res = top.val;
        }
        return res;
    }
    public static void main(String[] args) {
        put(1);
        put(2);
        System.out.println(peek());
        System.out.println(get());
    }
}
