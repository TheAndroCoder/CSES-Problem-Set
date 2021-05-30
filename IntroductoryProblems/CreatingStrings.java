import java.util.*;

public class CreatingStrings {
    static int count=0;
    static List<String> list=new ArrayList<>();
    static Map<String,Boolean> set=new HashMap<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        char[] chs=s.toCharArray();
        Arrays.sort(chs);

        s=new String(chs);
        permute(s,"");
        System.out.println(list.size());
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }


    static void permute(String s,String answer){
        if(s.length()==0 && !set.containsKey(answer)){
            //System.out.println(answer);
            list.add(answer);
            set.put(answer,true);
            //count++;
            return;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            String rest = left+right;
            permute(rest,answer+ch);
        }
    }
}

// THIS CODE DOESNOT WORK
