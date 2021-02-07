package LinkedList;

public class addTwoNumbers2 {
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
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node1.print(addTwoNumbers(node1,node5));

    }

    /*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int le1 = getNodeLength(l1);
            int le2 = getNodeLength(l2);
            ListNode n1 = le1>=le2?l1:l2;
            ListNode n2 = le1<le2?l1:l2;
            int temp = 0;//进位符
            ListNode node  = new ListNode();//记录长链表最后一个元素
            while(n1!=null && n2!=null){
                int sum = n1.val+n2.val+temp;
                if(sum%10 != sum){
                    temp=1;
                }else{
                    temp = 0;
                }
                n1.val = sum%10;
                node = n1;
                n1 = n1.next;
                n2 = n2.next;
            }

            while(n1 != null && n2 == null){
                int sum = n1.val+temp;
                if(sum%10 != sum){
                    temp=1;
                }else{
                    temp = 0;
                }
                n1.val = sum%10;
                node = n1;
                n1 = n1.next;
            }
            if(n1 == null && temp == 1){
                node.next = new ListNode(1);
            }
            return le1>=le2?l1:l2;

    }

    private static int getNodeLength(ListNode node){
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }

}
