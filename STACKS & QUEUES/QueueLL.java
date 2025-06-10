import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next=null;
    }
}


public class QueueLL {
    Node start,end;
    int size=0;

    public void push(int x){
        Node newNode = new Node(x);
        if(start==null && end==null){
            start = end = newNode;
        }else{
            end.next = newNode;
        }
        size++;
    }

    public int pop(){
        if(start==null){
            return -1;
        }
        Node temp = start;
        start = start.next;
        size--;
        return temp.data;
        
    }

    public void top(){
        if(start==null){
            return;
        }
        System.out.println(start.data);
    }

    public void printQ(){
        Node temp = end;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLL q = new QueueLL();
        int t = sc.nextInt();
        while(t-->0){
            int x = sc.nextInt();
            q.push(x);
        }
        q.printQ();

    }
}
