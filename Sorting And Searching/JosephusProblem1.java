import java.util.Scanner;

public class JosephusProblem1 {
    static Node head=null,tail=null;
    static int size=0;
    static class Node{
        int data;
        Node next;
        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        public Node(){
            this.data=0;
            this.next=null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k=sc.nextInt();
        //Node head=null;
        for (int i = 1; i <=n ; i++) {
            insert(i);
            size++;
        }

        removeKNextNode(head,k);
    }
    static void removeNextNode(Node n){
        if(size==1){
            System.out.print(n.data);
        }else{
            Node rem=n.next;
            System.out.print(rem.data+" ");
            n.next=rem.next;
            rem=null;
            n=n.next;
            size--;
            removeNextNode(n);
        }
    }
    static void removeKNextNode(Node n,int k){
        if(size==1){
            System.out.print(n.data);
        }else{
            Node rem=null,prev=n;
            for(int i=0;i<k;i++)prev=prev.next;
            rem=prev.next;
            System.out.print(prev.data+" ");
            n.next=rem.next;
            //rem=null;
            n=n.next;
            rem=null;
            size--;
            removeNextNode(n);
        }
    }
    static void insert(int data){
        if(head==null){
            head=new Node();
            head.next=head;
            head.data=data;
            tail=head;
            return;
        }
        Node new_node=new Node(data,head);
        tail.next=new_node;
        tail=new_node;

    }
}
