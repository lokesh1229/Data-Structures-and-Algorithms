public class MaxDiff {
    
    public static int MaxDiff(int a[]){
        int n = a.length;
        int res = a[1] - a[0];
        int minval = a[0];
        for(int i=0;i<n;i++){
            res = Math.max(res , a[i]-minval);
            minval = Math.min(minval, a[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = {2,3,10,6,4,8,1};
        System.out.println(MaxDiff(a));
    }
}
