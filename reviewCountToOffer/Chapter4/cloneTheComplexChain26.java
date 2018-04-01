package reviewCountToOffer.Chapter4;

/**
 *
 * 复杂链表的复制；分三步走
 * 1：先将所有的节点全部复制一遍，每一个复制的节点插入打被复制的节点后面
 * 2：遍历一遍所有的节点然后将Before指针指向对应的位置
 * 3：将得到的链表结果进行拆分；
 * Created by cp on 2018/3/31.
 */
public class cloneTheComplexChain26 {
    public CNode Colone(CNode head){
        if(head == null){
            return head;
        }
        CNode chead = head;
        while(chead!=null){
            CNode tmp = new CNode(chead.val);
            CNode tNext  =chead.next;
            chead.next = tmp;
            tmp.next = tNext;
            chead= tNext;
        }
        CNode shead = head;
        while(shead!=null){
            if(shead.Pbefore!=null){
                shead.next.Pbefore = shead.Pbefore.next;
            }
            shead = shead.next.next;
        }
        CNode returnNode = head.next;
        while(head!=null){
            head.next =  head.next.next;
            head= head.next;
        }
        return returnNode;
    }

    public static void main(String[] args) {
        CNode node1 = new CNode(1);
        CNode node2 = new CNode(2);
        CNode node3 = new CNode(3);
        CNode node4 = new CNode(4);
        CNode node5 = new CNode(5);
        CNode node6 = new CNode(6);
        CNode node7 = new CNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        cloneTheComplexChain26 ctcc = new cloneTheComplexChain26();
        CNode res = ctcc.Colone(node1);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
class CNode{
    public int val;
    public CNode next;
    public CNode Pbefore;
    public CNode(int val){
        this.val = val;
    }
}
