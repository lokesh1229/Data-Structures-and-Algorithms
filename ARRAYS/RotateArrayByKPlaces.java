public class RotateArrayByKPlaces {
    
    public static void RotateArrayBydPlaces(int a[],int n,int d){
        d = d%n;
        int temp[] = new int[d];
        for(int i=0;i<d;i++){
            temp[i] = a[i];
        }
        for(int i=d;i<n;i++){
            a[i-d] = a[i];
        }
        for(int i=n-d;i<n;i++){
            a[i] = temp[i-(n-d)];
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int a[] = {1,2,3,4,5};
        int k = 3;
        RotateArrayBydPlaces(a,n,k);
        for(int i:a){
            System.out.print(i+" ");
        }

    }
}
