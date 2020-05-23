package byteDance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lizeyang
 * @Date:2020/5/23 17:34
 * function:LRU实现
 */
public class test56 {
    //方法2实现：双链表 + HashMap
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    test56(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        //先删除节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //提高优先级，连接尾部
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        moveToTail(node);
        if (map.size() > capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    public void moveToTail(Node node) {
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }

    public static void main(String[] args) {
        test56 test = new test56(3);
        test.put(1, 2);
        test.put(2, 3);
        test.put(3, 4);
        test.put(4, 5);
        System.out.println(test.get(3));
        test.put(2, 3);
        System.out.println(test.get(1));
    }
}
