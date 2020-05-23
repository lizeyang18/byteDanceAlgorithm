package byteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lizeyang on 2020/5/13.
 * 二叉树的先序非递归遍历 so easy~
 */
public class test15 {
    //辅助栈实现，时间复杂度O(n)，空间复杂度O(n)
    public static List<Integer> test(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
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
