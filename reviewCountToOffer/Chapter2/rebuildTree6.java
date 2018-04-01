package reviewCountToOffer.Chapter2;


import reviewCountToOffer.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by cp on 2018/3/27.
 */
public class rebuildTree6 {
    public TreeNode tree(int[] head, int[] middle){
        if(head==null || middle==null || head.length==0 || middle.length==0){
            return null;
        }
        int hend = head.length-1;
        int mend = middle.length-1;
        return build(head,0,hend,middle,0,mend);
    }
    public TreeNode build(int[] head, int hstart, int hend, int[] middle, int mstart, int mend){
        TreeNode treenode = new TreeNode(head[hstart]);
        treenode.left = null;
        treenode.right = null;
        if(hstart==hend || mstart==mend){
            return treenode;
        }
        int index = mstart;
        while(index<mend){
            if(middle[index]==head[hstart]){
                break;
            }
            index++;
        }
        int leftlen = index-mstart;
        int rightlen = mend-index;
        if(leftlen>0){
            treenode.left = build(head,hstart+1,hstart+leftlen,middle,mstart,index-1);
        }
            if(rightlen>0){
            treenode.right = build(head,hstart+leftlen+1,hend,middle,index+1,mend);
        }
        return treenode;
    }
    public void travelTree(TreeNode head){
        if(head == null){
            return;
        }
        System.out.println(head.val);
        travelTree(head.left);
        travelTree(head.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        int[] head = {1,2,3,4,5,6};
        int[] middle = {4,2,5,1,6,3};
        rebuildTree6 rbt = new rebuildTree6();
        TreeNode headnode = rbt.tree(head,middle);
        rbt.travelTree(headnode);
    }
}
