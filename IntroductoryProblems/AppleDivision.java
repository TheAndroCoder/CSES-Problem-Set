import java.util.Scanner;

public class AppleDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        long sum=0;
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
            sum+=a[i];
        }
        System.out.println(getMin(a,0,sum,n-1));
    }
    static long getMin(int a[],long curr,long total,int i){
        if(i==0){
            return Math.abs(total-2*curr);
        }
        return Math.min(getMin(a,curr+a[i],total,i-1),getMin(a,curr,total,i-1));
    }
}
