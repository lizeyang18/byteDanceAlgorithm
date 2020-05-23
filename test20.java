package byteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizeyang on 2020/5/13.
 * 1.求二叉树根节点到叶子结点的路径和最小值
 * 2.二叉树的所有路径和
 * 3.二叉树某一路径和为target
 */
public class test20 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    //所有路径
    public static List<List<Integer>> allRoad(TreeNode root) {
        if (root == null) {
            return res;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        allRoad(root.left);
        allRoad(root.right);
        list.remove(list.size() - 1);
        return res;
    }

    //最小路径和
    static int count = 0;
    static int min = Integer.MAX_VALUE;

    public static int minRoad(TreeNode root) {
        if (root == null) {
            return min;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            count = 0;
            for(int i=0;i<list.size();i++){
                count += list.get(i);
            }
            min = Math.min(min,count);
        }
        minRoad(root.left);
        minRoad(root.right);
        list.remove(list.size() - 1);
        return min;
    }

    //路径目标和为target
    public static List<List<Integer>> findTarget(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        target -= root.val;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        findTarget(root.left, target);
        findTarget(root.right, target);
        list.remove(list.size() - 1);
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

        //所有路径
//        List<List<Integer>> res = allRoad(root);

        //路径和为target
//        List<List<Integer>> res = findTarget(root,12);

        //最小路径和
        System.out.println(minRoad(root));

        /*for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }*/
    }
}
