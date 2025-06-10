public class Stack {
    int top;
    int arr[];
    int max ;
    Stack(int max){
        top = -1;
        this.max=max;
        arr = new int[max];
    }

    void push(int x){
        top++;
        arr[top]=x;
    }

    int pop(){
        int x = arr[top];
        top--;
        return x;
    }

    int peek(){
        return arr[top];
    }

    boolean isEmpty(){
        return top==-1;
    }

    void printStack(){
        for(int i=top;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Stack os = new Stack(5);
        os.push(1);
        os.push(2);
        os.push(3);
        os.push(4);
        os.push(5);
        os.pop();
        os.pop();
        // System.out.println(os.pop());
        System.out.println(os.peek());
        // os.printStack();
    }
}
