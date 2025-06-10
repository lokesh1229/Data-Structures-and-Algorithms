import java.util.*;
public class RemoveDuplicates {
    static ArrayList<Integer> m = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int x = removeDuplicates(a);
        System.out.println(x);
        System.out.println(m);
    }

    public static int removeDuplicates(int a[]){
        int n = a.length;
        
        int res = 1;
        for(int i=1;i<n;i++){
            if(a[i]!=a[res-1]){
                a[res]=a[i];
                res++;
            }
        }
        for(int i=0;i<res;i++){
            m.add(a[i]);
        }
        return res+1;
    }

}
