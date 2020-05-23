package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * 两个链表，可能相交，找出相交的节点
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class test07 {
    //无辅助空间，时间复杂度O(n)
    public static int test(ListNode root1, ListNode root2) {
        if (root1 == null || root2 == null) {
            return 0;
        }
        int count = 0;
        ListNode p = root1;
        ListNode q = root2;
        while (p != null) {
            count++;
            p = p.next;
        }
        while (q != null) {
            count--;
            q = q.next;
        }
        ListNode head1 = root1;
        ListNode head2 = root2;
        if (count > 0) {
            while (count > 0) {
                head1 = head1.next;
                count--;
            }
        } else {
            while (count != 0) {
                head2 = head2.next;
                count++;
            }
        }
        ListNode h1 = root1;
        ListNode h2 = root2;
        while (h1 != null && h2 != null && h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1.val;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(4);
        head2.next = head1.next.next;

        System.out.println(test(head1, head2));
    }
}
