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

public class Sort012 {

    
    //NAIVE
    public static Node Sort2(Node head){
        Node temp = head;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        while(temp!=null){
            if(temp.data==0){
                c0++;
            }
            else if(temp.data==1){
                c1++;
            }
            else{
                c2++;
            }
            temp = temp.next;
        }
        while(temp!=null){
            if(c0>0){
                temp.data = 0;
                c0--;
            }
            else if(c1>0){
                temp.data = 1;
                c1--;
            }
            else if(c2>0){
                temp.data = 2;
                c2--;
            }
            temp = temp.next;
        }
        return head;
    }
    
    //EFFICIENT
    public static Node Sort1(Node head){
        if(head==null || head.next==null){
            return head;
        }

        Node ZeroHead = new Node(-1);
        Node OneHead = new Node(-1);
        Node TwoHead = new Node(-1);

        Node zero = ZeroHead;
        Node one = OneHead;
        Node two = TwoHead;
        Node temp = head;
        
        while (temp!=null) {
            if(temp.data==0){
                zero.next = temp;
                zero = zero.next;
            }
            else if (temp.data==1) {
                one.next = temp;
                one = one.next;
            }else if(temp.data==2){
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        if(OneHead.next!=null){
            zero.next = OneHead.next;
        }
        else{
            zero.next = TwoHead.next;
        }
        one.next = TwoHead.next;
        two.next = null;

        Node temp2 = ZeroHead.next;
        return temp2;
    }
    
    public static void printLL(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }

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

    public static void main(String[] args) {
        int a[] = {1,0,1,2,0,2,1};
        Node head = ConvertArr2LL(a);
        Node head2 = Sort1(head);
        printLL(head2);
    }
}