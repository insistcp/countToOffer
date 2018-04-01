package reviewCountToOffer.Chapter4;

import reviewCountToOffer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cp on 2018/3/30.
 */
public class getSumToValueFromTree25 {
    public void getThePathToNumber(TreeNode head,int tagert){
        if(head == null){
            return;
        }
        if(head.val>tagert){
            return;
        }
        List<Integer> list = new ArrayList<Integer>();
        getPath(head,tagert,list);

    }
    private List<List<Integer>> flist = new ArrayList<>();
    public void getPath(TreeNode head,int target,List<Integer> list){
        if(head==null || head.val>target){
            return;
        }else if(head.val==target){
            list.add(head.val);
            flist.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(head.val);
        getPath(head.left,target-head.val,list);
        getPath(head.right,target-head.val,list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        getSumToValueFromTree25 stvf = new getSumToValueFromTree25();
        stvf.getThePathToNumber(node1,7);
        for(List<Integer> list:stvf.flist){
            for(Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
