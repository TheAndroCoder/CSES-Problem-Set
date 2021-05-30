import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TwoSets {
    public static void main(String[] args)throws IOException {
        Reader sc=new Reader();
        int n=sc.nextInt();
        long sum = (n*(n+1))/2;
        if((sum&1)!=0){
            // sum is odd
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        if((n&1)==0){
            // n is even
            int first = 1;
            int last = n;
            boolean b = true;
            while(first<last){
                if(b){
                    l1.add(first);
                    l1.add(last);
                    b=!b;
                }else{
                    l2.add(first);
                    l2.add(last);
                    b=!b;
                }
                first++;
                last--;
            }
        }else{
            // n is odd
            int first =1;
            int last = n-1;
            boolean b=true;
            while(first<last){
                if(b){
                    l1.add(first);
                    l1.add(last);
                    b=!b;
                }else{
                    l2.add(first);
                    l2.add(last);
                    b=!b;
                }
                first++;
                last--;

            }
            //l1.add(n);
        }
        System.out.println(l1.size());
        for (int i = 0; i <l1.size() ; i++) {
            System.out.print(l1.get(i)+" ");
        }
        System.out.println();
        System.out.println(l2.size());
        for (int i = 0; i <l2.size() ; i++) {
            System.out.print(l2.get(i)+" ");
        }
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
