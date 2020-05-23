package byteDance;

/**
 * Created by lizeyang on 2020/5/16.
 * 求完全二叉树的节点个数，小于O(n)，并分析复杂度
 */
public class test49 {
    //O(n)，空间复杂度O(d)=O(logn),d是二叉树的高度
    public static int test(TreeNode root) {
        return root != null ? 1 + test(root.left) + test(root.right) : 0;
    }

    //利用完全二叉树的特点，除了最后一层外，其余每层节点都是满的，并且最后一层的节点全部靠向左边
    // 二分搜索
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d = getDepth(root);
        if (d == 0) {
            return 1;
        }
        int l = 1, r = (int) Math.pow(2, d) - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (exist(mid, d, root)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) Math.pow(2, d) - 1 + l;
    }

    public static boolean exist(int cur, int level, TreeNode root) {
        int l = 0, r = (int) Math.pow(2, level) - 1;
        int mid;
        for (int i = 0; i < level; i++) {
            mid = (l + r) >> 1;
            if (cur <= mid) {
                root = root.left;
                r = mid;
            } else {
                root = root.right;
                l = mid + 1;
            }
        }
        return root != null;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(10);
        //O(n)
        System.out.println(test(root));
        //O(logn)
        System.out.println(countNodes(root));
    }
}
