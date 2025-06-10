import java.util.*;
public class Queue {
    int size = 10;
    int q[] = new int[size];
    int start = -1;
    int end = -1;
    int curr = 0;

    public void push(int x){
        if(curr==size){
            System.out.println("Queue is Full");
        }
        if(curr==0){
            start=end=0;
        }
        else{
            end = (end+1)%size;
            q[end] = x;
            curr+=1;
        }
    }

    int pop(){
        if(curr==0){
            return 0;
        }
        if(curr==1){
            start = end =-1;
        }
        int el = q[start];
        start = (start+1)%size;
        curr-=1;
        return el;
    }

    public void display(){
        for(int i=start;i<end;i++){
            System.out.print(q[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int t = sc.nextInt();
        while(t-->0){
            int x = sc.nextInt();
            q.push(x);
        }
        q.display();
    }
}
