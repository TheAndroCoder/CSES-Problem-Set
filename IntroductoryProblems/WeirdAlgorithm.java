import java.io.IOException;
import java.io.*;
import java.util.StringTokenizer;

public class WeirdAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st
                = new StringTokenizer(br.readLine());
        long n=Long.parseLong(st.nextToken());
        System.out.print(n+" ");
        while(n!=1){
            if(n%2==0){
                n/=2;
                System.out.print(n+" ");
            }else{
                n=(n*3)+1;
                System.out.print(n+" ");
            }
        }
    }
}
