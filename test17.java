package byteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lizeyang on 2020/5/13.
 * 二叉树非递归后序遍历
 */
public class test17 {
    //时间复杂度O(n)，额外空间复杂度O(2n)
    public static List<Integer> test(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
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
