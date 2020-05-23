package byteDance;

/**
 * Created by lizeyang on 2020/5/14.
 * 重建二叉树
 */
public class test24 {
    //根据先序中序序列恢复二叉树
    public static TreeNode test(int[] pre,int[] in){
        if(pre==null||in==null||pre.length!=in.length){
            return null;
        }
        return reBuild(pre,0,pre.length-1,in,0,in.length-1);
    }
    public static TreeNode reBuild(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for(int i=inStart;i<=inEnd;i++){
            if(in[i] == root.val){
                root.left = reBuild(pre,preStart+1,preStart+i-inStart,in,inStart,i);
                root.right = reBuild(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
            }
        }
        return root;
    }
}
