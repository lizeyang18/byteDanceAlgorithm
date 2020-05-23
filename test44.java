package byteDance;

/**
 * Created by lizeyang on 2020/5/16.
 * 二叉树的最近公共祖先
 */
public class test44 {
    public static TreeNode test(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = test(root.left, p, q);
        TreeNode right = test(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(test(root, root.right, root.left.left).val);
    }
}
