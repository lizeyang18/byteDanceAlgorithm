package byteDance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lizeyang on 2020/5/14.
 * 二叉树最大深度，最小深度
 */
public class test21 {
    /*
    * 二叉树深度：
    * 1.二叉树只有一个节点，深度为1
    * 2.二叉树的左子树为空，深度为右子树深度+1；
    * 3.二叉树的右子树为空，深度为左子树深度+1；
    * 4.二叉树的左子树，右子树都不为空，最大深度为左右子树深度最大值+1，最小深度为左右子树最小值+1。
    * */


    //最大深度递归实现
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left==null){
            return maxDepth(root.right)+1;
        }
        if(root.right==null){
            return maxDepth(root.left)+1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    //最大深度非递归实现——层次遍历
    public static int maxDepthNonRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

    //最小深度递归实现
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    //最小深度非递归实现-层次遍历
    public static int minDepthNonRecu(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //一旦遇到叶子节点，即最短深度
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(maxDepth(root));
        System.out.println(maxDepthNonRecur(root));
        System.out.println(minDepth(root));
        System.out.println(minDepthNonRecu(root));
    }
}
