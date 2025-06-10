import java.util.*;
public class SpiralMatrix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a[][] = new int[m][n];
        int top = 0, left=0, bottom = m-1,right = n-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        // print(a);
        spiralPrint(a);
    }

    public static void print(int a[][]){
        int m = a.length;
        int n = a[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void spiralPrint(int a[][]){
        int m = a.length;
        int n = a[0].length;
        int top = 0, left=0, bottom = m-1,right = n-1;
        while (left<=right && top<=bottom) {
            for(int i=left;i<=right;i++){
                System.out.print(a[top][i]+" ");
            }
            top++;

            for(int i=top;i<=bottom;i++){
                System.out.print(a[i][right]+" ");
            }
            right--;

            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    System.out.print(a[bottom][i]+" ");
                }
            }
            bottom--;

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    System.out.print(a[i][left]+" ");
                }
            }
            left++;
        }
    }
}