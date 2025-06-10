package SINGLYLINKEDLIST;

public class Add1toNumber extends SingleLinkedList{

    public static Node Add1toNumberfun1(Node head){
        int carry = 1;
        head = reverse(head);
        Node temp = head;
        while (temp!=null) {
            temp.data+=carry;
            if(temp.data<10){
                carry=0;
                break;
            }
            else{
                temp.data=0;
                carry=1;
            }
            temp = temp.next;
        }
        if(carry==1){
            Node newNode = new Node(carry);
            head = reverse(head);
            newNode.next = head;
            return newNode;
        }
        head = reverse(head);
        return head;
    }

    public static Node Add1toNumberfun2(Node head){
        int carry = helper(head);
        if(carry == 1){
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    private static int helper(Node temp){
        if(temp==null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.data+=carry;
        if(temp.data<10){
            return 0;
        }
        temp.data=0;
        return 1;
    }

    public static void main(String[] args) {
        int arr[] = {9,9,9};
        Node head = ConvertArr2LL(arr);
        Node head2 = Add1toNumberfun2(head);
        printLL(head2);
    }
}