package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * 链表求和
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 */
public class test11 {
    //时间复杂度O(m+n)
    public static ListNode test(ListNode root1, ListNode root2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        int sum =0;
        while(root1!=null||root2!=null||carry>0){
            int value1 = root1==null?0:root1.val;
            int value2 = root2==null?0:root2.val;
            sum = value1+value2+carry;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            if(root1!=null){
                root1= root1.next;
            }
            if(root2!=null){
                root2 = root2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(7);
        root1.next = new ListNode(1);
        root1.next.next = new ListNode(6);
        root1.next.next.next = null;

        ListNode root2 = new ListNode(5);
        root2.next = new ListNode(9);
        root2.next.next = new ListNode(2);
        root2.next.next.next = null;

        ListNode res = test(root1, root2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
