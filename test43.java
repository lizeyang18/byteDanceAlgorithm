package byteDance;

import java.util.Stack;

/**
 * Created by lizeyang on 2020/5/16.
 * 链表正向相加，反向相加（在不改变链表结构的基础上）
 */
public class test43 {
    //正向相加，时间复杂度O(max(m,n))
    public static ListNode test(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        //carry表示进位
        int carry = 0, sum = 0;
        ListNode head = new ListNode(0), dummy = head;
        head.next = null;
        //注意采用尾插法
        while (head1 != null || head2 != null || carry > 0) {
            int value1 = head1 == null ? 0 : head1.val;
            int value2 = head2 == null ? 0 : head2.val;
            sum = value1 + value2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            head.next = node;
            head = node;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        return dummy.next;
    }

    //反向相加，利用两个stack
    public static ListNode backSum(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        int carry = 0, sum = 0;
        ListNode head = new ListNode(0);
        head.next = null;
        //注意采用头插法
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int value1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int value2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            sum = value1 + value2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(6);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(7);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(5);

        //正向相加
//        ListNode res = test(head1, head2);

        //反向相加
        ListNode res = backSum(head1, head2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
