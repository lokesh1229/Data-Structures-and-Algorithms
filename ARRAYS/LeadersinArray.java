public class LeadersinArray {

    public static void findLeaders(int a[]){
        int n = a.length;
        int curr = a[n-1];
        System.out.print(curr+" ");
        for(int i=n-2;i>=0;i--){
            if(curr<a[i]){
                curr = a[i];
                System.out.print(curr+" ");
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {44,5,16,7,9,12,2};
        findLeaders(a);
    }
    
}
