package byteDance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lizeyang on 2020/5/15.
 * 二叉树的各层节点数
 */
public class test32 {
    //非递归实现
    public static List<Integer> test(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.add(size);
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
        return list;
    }

    //递归实现
    static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> levelTraverse(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        int depth = getDepth(root);
        for(int i=0;i<depth;i++){
           res.add(new ArrayList<>());
        }
        printNodeAtLevel(root,res,0);
        for(int i=0;i<res.size();i++) {
            list.add(res.get(i).size());
        }
        return list;
    }
    public static void printNodeAtLevel(TreeNode root,List<List<Integer>> res,int level){
       if(root==null){
           return;
       }
        res.get(level).add(root.val);
        printNodeAtLevel(root.left,res,level+1);
        printNodeAtLevel(root.right,res,level+1);
    }
    public static int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return getDepth(root.right)+1;
        }
        if(root.right==null){
            return getDepth(root.left)+1;
        }
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        //非递归调用
//        List<Integer> res = test(root);

        //递归调用
        List<Integer> res = levelTraverse(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }

    }
}
