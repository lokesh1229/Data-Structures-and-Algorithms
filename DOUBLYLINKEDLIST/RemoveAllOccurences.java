package DOUBLYLINKEDLIST;

public class RemoveAllOccurences extends DoublyLinkedList {
    
    public static Node RemoveAllOccurencesFun(Node head, int val){
        Node temp = head;
        while (temp!=null) {
            if(temp.data==val){
                if(temp == head){
                    head = head.next;
                }
                Node nextNode = temp.next;
                Node prevNode = temp.back;
                if(nextNode!=null){
                    nextNode.back = prevNode;
                }
                if(prevNode!=null){
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,4,4,5};
        Node head = convertArr2LL(arr);
        Node head2 = RemoveAllOccurencesFun(head, 1);
        printLL(head2);
    }
}
