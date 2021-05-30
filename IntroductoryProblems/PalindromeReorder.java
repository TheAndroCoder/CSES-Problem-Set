

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromeReorder {
    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        //Map<Integer,Integer> map=new HashMap<>();
        int count[]=new int[26];
        Arrays.fill(count,0);
        char[] ch = s.toCharArray();
        for(char c : ch){
            int chNum = (int)c;
            chNum-=65;
            count[chNum]++;
        }
        // if any char has occured odd num of times , put it in middle.
        // if more than 1 char have occured odd num of times, print NO SOLUTION
        if(s.length()==1){
            System.out.println(s);
            return;
        }
        boolean hasSoln=true;
        // check how many have odd count also check which char occured once also count number of distinct characters
        int oddCount=0;
        int oddChar=0;
        int charCount=0;
        for(int i=0;i<26;i++){
            if(count[i]!=0 ){
                if(count[i]%2!=0){
                    oddCount++;
                    oddChar=i;
                }
                charCount++;
            }
        }
        if(charCount==1){
            System.out.println(s);
            return;
        }
        if(oddCount>1 && charCount>1)hasSoln=false;
        if(!hasSoln){
            System.out.println("NO SOLUTION");
            return;
        }
        else{
            StringBuffer sb = new StringBuffer();
            if(oddCount==1){
                //System.out.println("Appended="+(char)oddChar);
                sb.append((char)(oddChar+65));
                count[oddChar]--;
            }
            // prepend half count and append half Count
            for(int i=0;i<26;i++){
                if(count[i]!=0){
                    String make = makeString(i,count[i]/2);
                    sb.insert(0,make);
                    sb.append(make);
                }
            }
            System.out.println(sb.toString());
        }
    }
    static String makeString(int i,int count){
        char ch[] = new char[count];
        Arrays.fill(ch,(char)(i+65));
        return new String(ch);
    }
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
