package DOUBLYLINKEDLIST;

class Node {
    int data;
    Node next;
    Node back;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }
}

public class DoublyLinkedList {

    public static Node convertArr2LL(int[] a) {
        if (a.length == 0) return null;
        Node head = new Node(a[0]);
        Node mover = head;
        for (int i = 1; i < a.length; i++) {
            Node temp = new Node(a[i]);
            temp.back=mover;
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            curr.back = next;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static Node insertBegin(Node head,int data){
        Node newNode = new Node(data);
        if(head==null){
            return newNode;
        }
        newNode.next=head;
        head.back=newNode;
        head=newNode;
        return head;
    }

    public static Node insertTail(Node head,int data){
        Node newNode = new Node(data);
        if(head==null){
            return newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.back=temp;
        return head;
    }

    public static Node insertBeforeTail(Node head,int data){
        Node newNode = new Node(data);
        if(head==null){
            return newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node prev=temp.back;
        newNode.next=temp;
        newNode.back=prev;
        prev.next=newNode;
        temp.back=newNode;
        return head;
    }

    public static Node insertBeforeKthEle(Node head,int data,int k){
        if(head==null){
            return null;
        }
        if(k==1){
            return insertBegin(head, data);
        }
        Node temp = head;
        int c = 0;
        while(temp!=null){
            c++;
            if(c==k){
                break;
            }
            temp=temp.next;
        }
        Node prev=temp.back;
        Node newNode = new Node(data,temp,prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }

    public static Node removeHead(Node head){
        if(head==null){
            return null;
        }
        head=head.next;
        head.back=null;
        return head;
    }

    public static Node removeTail(Node head){
        if(head == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next=null;
        temp.back=null;
        return head;
    }

    public static Node removeKthEle(Node head,int k){
        if(head==null){
            return null;
        }
        if(k==1){
            return removeHead(head);
        }
        Node kthNode = head;
        int c=0;
        while(kthNode!=null){
            c++;
            if(c==k){
                break;
            }
            kthNode = kthNode.next;
        }
        Node prev = kthNode.back;
        Node front = kthNode.next;
        if(front==null && prev ==null){
            return null;
        }
        if(prev==null){
            return removeHead(head);
        }
        if(front==null){
            return removeTail(head);
        }
        prev.next=front;
        front.back=prev;
        return head;
    }

    public static void DeleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;
        if(front==null){
            prev.next=null;
            temp.back=null;
            return;
        }
        prev.next=front;
        front.back=prev;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Node head = convertArr2LL(a);
        Node head2 = reverse(head);
        printLL(head2);
    }
}
