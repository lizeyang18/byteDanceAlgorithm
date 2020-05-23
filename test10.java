package byteDance;

import java.util.*;

/**
 * Created by lizeyang on 2020/5/12.
 * 之字形遍历二叉树
 */
public class test10 {
    //奇数行用队列输出，偶数行用stack输出，时间复杂度O(n)，空间复杂度O(2n)
    public static List<List<Integer>> test(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        res.add(new ArrayList<>());
        int level = 0;
        res.get(level++).add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (level % 2 != 0) {
                        stack.push(node.left);
                    } else {
                        res.get(level).add(node.left.val);
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (level % 2 != 0) {
                        stack.push(node.right);
                    } else {
                        res.get(level).add(node.right.val);
                    }
                    queue.offer(node.right);
                }
            }
            if (level % 2 != 0) {
                while (!stack.isEmpty()) {
                    res.get(level).add(stack.pop().val);
                }
            }
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        List<List<Integer>> res = test(root);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
