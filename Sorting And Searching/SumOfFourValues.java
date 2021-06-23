import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class SumOfFourValues {
    static class Pair{
        int data,pos;
    }
    public static void main(String[] args)throws IOException {
        SumOfThreeValues.Reader sc = new SumOfThreeValues.Reader();
        int n=sc.nextInt();
        long x = sc.nextLong();
        SumOfThreeValues.Pair a[]=new SumOfThreeValues.Pair[n];
        for (int i = 0; i < n; i++) {
            SumOfThreeValues.Pair p=new SumOfThreeValues.Pair();
            p.data=sc.nextInt();
            p.pos=i+1;
            a[i]=p;
        }
        Arrays.sort(a, new Comparator<SumOfThreeValues.Pair>() {
            @Override
            public int compare(SumOfThreeValues.Pair o1, SumOfThreeValues.Pair o2) {
                return o1.data-o2.data;
            }
        });
        for(int j=0;j<n-3;j++){
            for (int i = j+1; i <n-2 ; i++) {
                //long fix = a[i].data;
                int low=i+1;
                int high = n-1;
                while(low<high){
                    long sum = a[j].data+a[i].data+a[low].data+a[high].data;
                    if(sum==x){
                        System.out.println(a[i].pos+" "+a[low].pos+" "+a[high].pos+" "+a[j].pos);
                        return;
                    }else if(sum>x){
                        high--;
                    }else{
                        low++;
                    }
                }
            }}
        System.out.println("IMPOSSIBLE");
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
