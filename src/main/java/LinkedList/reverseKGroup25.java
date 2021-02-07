package LinkedList;

public class reverseKGroup25 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node1.print(node1);
        reverseKGroup(node1,4);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode tempNode = getNode(head,k);
        if(tempNode == null) return head;
        ListNode newHead = tempNode;
        ListNode last = null;//前一个k中最后一个node,需要调整next的节点
        while(tempNode != null){
            if(last != null){
                ListNode temp = last.next;
                last.next =tempNode;
                last = temp;
            }else{
                last = head;
            }

            ListNode pre = tempNode.next;
            tempNode = tempNode.next;

            while(head!= null && head != tempNode){

                ListNode temp = head.next;
                head.next=pre;
                pre = head;
                head = temp;
            }

            newHead.print(newHead);
            tempNode = getNode(tempNode,k);
        }

        return newHead;
    }

    //获取head后k个node
    private static ListNode getNode(ListNode head,int k){
        while(k>1 && head != null){
            head = head.next;
            k--;
        }
        return k==1?head:null;
    }




}
