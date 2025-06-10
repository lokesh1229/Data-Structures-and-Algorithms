public class SecondLargest {

    public static int SecondLargest(int a[]){
        int n = a.length;
        int larget = Integer.MIN_VALUE;
        int secmax = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]>larget){
                secmax = larget;
                larget = a[i];
            }
            else if(a[i]!=larget && a[i]>secmax){
                secmax = a[i];
            }
        }
        return secmax;
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        System.out.println(SecondLargest(a));
    }
}
