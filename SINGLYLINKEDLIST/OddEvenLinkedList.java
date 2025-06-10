package SINGLYLINKEDLIST;
import java.util.*;
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

public class OddEvenLinkedList {

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

    public static Node OddEvenLinkedListfun(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node odd = head;
        Node evenNode = head.next;
        Node even = head.next;
        while (even!=null && even.next!=null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenNode;
        return head;
    }
    
    public static Node OddEvenLinkedList2(Node head){
        ArrayList<Integer> a = new ArrayList<>();
        if(head==null || head.next==null){
            return head;
        }
        Node temp1 = head;
        while(temp1!=null && temp1.next!=null){
            a.add(temp1.data);
            temp1 = temp1.next.next;
        }
        if(temp1!=null){
            a.add(temp1.data);
        }

        Node temp2 = head.next;
        while (temp2!=null && temp2.next!=null) {
            a.add(temp2.data);
            temp2 = temp2.next.next;
        }
        if(temp2!=null){
            a.add(temp2.data);
        }

        int i = 0;
        Node temp = head;
        while(temp!=null){
            temp.data = a.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,4,2,5,6};
        Node head = ConvertArr2LL(arr);
        Node x = OddEvenLinkedListfun(head);
        printLL(x);
    }
}
