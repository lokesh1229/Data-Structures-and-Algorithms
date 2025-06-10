public class BuyandSellStocks1 {
    
    public static int BuyandSellStocks(int a[]){
        int n = a.length;
        int profit = 0;
        for(int i=1;i<n;i++){
            if(a[i]>a[i-1]){
                profit+=(a[i]-a[i-1]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int a[] = {1,5,3,8,12};
        System.out.println(BuyandSellStocks(a));
    }
}
