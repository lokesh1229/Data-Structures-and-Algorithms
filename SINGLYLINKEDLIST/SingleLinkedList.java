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

public class SingleLinkedList {

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

    public static int length(Node head){
        Node temp = head;
        int c = 0;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        return c;
    }

    public static void printLL(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
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
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static int search(Node head,int k){
        Node temp = head;
        while(temp!=null){
            if(temp.data==k){
                return 1;
            }
            temp = temp.next;
        }
        return -1;
    }

    public static Node insertatHead(Node head,int data){
        Node newNode = new Node(data);
        if(head==null){
            return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node insertatTail(Node head,int data){
        Node newNode = new Node(data);
        if(head == null){
            return newNode;
        }
        Node temp = head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static Node insertatPos(Node head,int data,int k){
        if(head == null){
            if(k==1){
                return new Node(data,head);
            }else{
                return head;
            }
        }
        if(k==1){
            return insertatHead(head, data);
        }
        int c=0;
        Node temp = head;
        while(temp!=null){
            c++;
            if(c==(k-1)){
                Node x = new Node(data);
                x.next = temp.next;
                temp.next = x;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    public static Node insertBefore(Node head,int data,int val){
        if(head==null){
            return null;
        }
        if(head.data==val){
            return insertatHead(head, val);
        }
        Node temp = head;
        while (temp.next!=null) {
            if(temp.next.data==val){
                Node x = new Node(data);
                x.next=temp.next;
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node DelHead(Node head){
        if(head==null){
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node DelTail(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node removeKele(Node head,int k){
        if(head==null){
            return head;
        }
        if(k==1){
            return DelHead(head);
        }
        Node temp = head;
        int c = 0;
        Node prev = null;
        while(temp!=null){
            c++;
            if(c==k){
                prev.next = prev.next.next;
            }
            prev=temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node removeEle(Node head,int val){
        if(head==null){
            return null;
        }
        if(head.data==val){
            return DelHead(head);
        }
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            if(temp.data==val){
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};
        Node head = ConvertArr2LL(a);
        // Node newHead = insertatTail(head, 7);
        // System.out.println(search(newHead, 9));
        // Node delNode = removeEle(head,1);
        Node head2 = reverse(head);
        printLL(head2);
    }
}
