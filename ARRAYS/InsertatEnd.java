import java.util.*;
public class InsertatEnd{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n-1;i++){
            a[i]=sc.nextInt();
        }
        printArr(a);
        int key=sc.nextInt();
        InsertatEnd(a,key);
        printArr(a);
    }
    
    public static void printArr(int a[]){
        for(int i:a){
            System.out.print(i+" ");
        }
    }

    public static void InsertatEnd(int a[], int k){
        for(int i=0;i<a.length;i++){
            a[a.length-1]=k;
        }
    }
}