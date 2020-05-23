package byteDance;

/**
 * Created by lizeyang on 2020/5/14.
 * 反转链表
 */
public class test22 {
    //原地反转链表,O(n)
    public static ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode pre = null;
        ListNode index = root;
        ListNode last = index.next;
        while (last != null) {
            index.next = pre;
            pre = index;
            index = last;
            last = last.next;
        }
        index.next = pre;
        return index;
    }

    //升级->每k个反转一下,O(n)
    public static ListNode reverseListK(ListNode root, int k) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode dummy = new ListNode(0), pre = dummy, cur = root, last;
        dummy.next = root;
        int length = 0;
        while (root != null) {
            length++;
            root = root.next;
        }
        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                last = cur.next;
                cur.next = last.next;
                last.next = pre.next;
                pre.next = last;
            }
            pre = cur;
            cur = pre.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(4);
        root.next.next.next = new ListNode(5);
        root.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next = new ListNode(8);
        root.next.next.next.next.next.next = new ListNode(9);

        //反转链表
//        ListNode res = reverseList(root);

        //每k个反转链表
        ListNode res = reverseListK(root, 3);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
