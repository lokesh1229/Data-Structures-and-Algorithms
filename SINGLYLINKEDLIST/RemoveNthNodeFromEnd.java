package SINGLYLINKEDLIST;

class Node{
    int data;
    Node next;
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
    Node(int data1,Node next1){
        this.data = data1;
        this.next = next1;
    }
}

public class RemoveNthNodeFromEnd {

    public static Node ConvertArr2LL(int a[]){
        Node head = new Node(a[0]);
        Node mover = head;
        for(int i=1;i<a.length;i++){
            Node temp = new Node(a[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void printLL(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    //NAIVE
    public static Node RemoveNode(Node head,int k){
        Node temp = head;
        int c = 0;
        while (temp!=null) {
            c++;
            temp = temp.next;
        }
        Node temp1 = head;
        int pos = c - k;
        while(temp1!=null){
            pos--;
            if(pos==0){
                break;
            }
            temp1 = temp1.next;
        }
        temp1.next = temp1.next.next;
        return head;
    }

    public static Node RemoveNodeFromEnd(Node head,int k){
        Node slow = head;
        Node fast = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while (fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Node delNode = slow.next;
        slow.next = slow.next.next;
        return head;

    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};
        Node head = ConvertArr2LL(a);
        Node head1 = RemoveNodeFromEnd(head, 4);
        printLL(head1);
    }

}
