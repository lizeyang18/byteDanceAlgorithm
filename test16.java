package byteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lizeyang on 2020/5/13.
 * 二叉树非递归中序遍历
 */
public class test16 {
    public static List<Integer> test(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        List<Integer> res = test(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
