package byteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizeyang on 2020/5/15.
 * 二叉树右视图
 */
public class test36 {
    //非递归写的太多了，多写写递归的，万一面试官让你都写呢——层次遍历实现
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static List<Integer> test(TreeNode root) {
        if (root == null) {
            return list;
        }
        int depth = getDepth(root);
        for (int i = 0; i < depth; i++) {
            res.add(new ArrayList<>());
        }
        reverseNodeAtLevel(root, 0, res);
        for (int i = 0; i < res.size(); i++) {
            list.add(res.get(i).get(res.get(i).size() - 1));
        }
        return list;
    }

    public static void reverseNodeAtLevel(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        res.get(level).add(root.val);
        reverseNodeAtLevel(root.left, level + 1, res);
        reverseNodeAtLevel(root.right, level + 1, res);
    }

    //求最大深度，递归实现，递归赛高！
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return getDepth(root.right) + 1;
        }
        if (root.right == null) {
            return getDepth(root.left) + 1;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
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
