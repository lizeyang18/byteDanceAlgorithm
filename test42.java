package byteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lizeyang on 2020/5/16.
 * 二叉排序树找第k大的元素
 */
public class test42 {
    //利用二叉搜索树的特点，左<中<右，再利用中序排序即可
    public static int test(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
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
        if (k > list.size() || k < 0) {
            return 0;
        }
        return list.get(list.size() - k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(test(root, 5));
    }
}
