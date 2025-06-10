package STRINGS;
import java.util.*;
public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        String a[] = s.split(" ");
        List<List<String>> ans = new ArrayList<List<String>>();
        int n = a.length;
        int c = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                String x = a[i];
                String y = a[j];
                if(isAnagram(x, y)){
                    ans.add(x,y);
                    c++;
                }
            }
        }
        if(c==0){
            System.out.println("No Anagrams Found");
        }
        sc.close();
    }

    public static boolean isAnagram(String x,String y){
        if(x.length()!=y.length()){
            return false;
        }
        char a[] = x.toCharArray();
        char b[] = y.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        boolean res = Arrays.equals(a, b);
        if(res){
            return true;
        }
        return false;
    }
}
