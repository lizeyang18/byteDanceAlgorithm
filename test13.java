package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * 二叉树中的最大路径和
 */
public class test13 {
    static int res = Integer.MIN_VALUE;
    /*
    * 对于任意一个节点，如果它在最大路径和里面，有两种情况：
    * 1.当前节点的左子树和右子树取较大的值加上自己节点的值再回溯找到父节点构成最大路径
    * 2.当前节点的左子树，右子树都在最大路径和里，左右子树节点值加上自己节点的值构成最大路径和
    * */
    public static int test(TreeNode root) {
        getMax(root);
        return res;
    }
    public static int getMax(TreeNode root){
        if (root == null) {
            return 0;
        }
        //如果子树路径和为负应当置为0表示最大路径不包含该子树
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0,getMax(root.right));
        //判断在该节点包含左右子树的路径和是否大于当前最大路径和
        res = Math.max(res,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
