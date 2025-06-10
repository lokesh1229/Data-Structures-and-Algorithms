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

public class AddTwoNumbers {

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

    public static Node AddTwoNumbers1(Node head1,Node head2){
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        Node temp1 = head1;
        Node temp2 = head2;
        int carry = 0;
        while (temp1!=null || temp2!=null) {
            int sum = carry;
            if(temp1!=null){
                sum+=temp1.data;
            }
            if(temp2!=null){
                sum+=temp2.data;
            }
            Node newNode = new Node(sum%10);
            carry = sum/10;
            curr.next = newNode;
            curr = curr.next;
            if(temp1!=null){
                temp1 = temp1.next;
            }
            if(temp2!=null){
                temp2 = temp2.next;
            }
        }
        if(carry!=0){
            Node newNode = new Node(carry);
            curr.next = newNode;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int arr1[] = {2,4,6};
        int arr2[] = {3,8,7};
        Node head1 = ConvertArr2LL(arr1);
        Node head2 = ConvertArr2LL(arr2);
        Node ans = AddTwoNumbers1(head1, head2);
        printLL(ans);
    }
}
