package reviewCountToOffer.Chapter3;

import reviewCountToOffer.TreeNode;

/**
 *
 * 给定两个树的头节点A,B，让你判断树B 是否是树A的孩子结构树。
 * Created by cp on 2018/3/29.
 */
public class TheTreeSonStructure18 {
    public boolean TreeAHasTreeB(TreeNode A,TreeNode B){
        boolean flag = false;
        if(A!=null && B!=null){
            if(A.val == B.val){
                flag = isTreeSon(A,B);
            }
            if(!flag){
                flag = TreeAHasTreeB(A.left,B);
            }
            if(!flag){
                flag = TreeAHasTreeB(A.right,B);
            }
        }
        return  flag;
    }
    public boolean isTreeSon(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }
        return isTreeSon(A.left,B.left) && isTreeSon(A.right,B.right);

    }

    public static void main(String[] args) {
        TheTreeSonStructure18 tts = new TheTreeSonStructure18();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(3);
        node4.left = node5;
        node4.right = node6;
        boolean flag = tts.TreeAHasTreeB(node1,node4);
        System.out.println(flag);
    }
}
