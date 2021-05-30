import java.util.Arrays;
import java.util.Scanner;

public class ChessBoardQueens {
    static int count=0;
    static int board[][];
    static char a[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a=new char[8][8];
        board=new int[8][8];
        //Arrays.fill(board,0);
        for (int i = 0; i < 8; i++) {
            String s=sc.next();
            for (int j = 0; j <8 ; j++) {
                a[i][j]=s.charAt(j);
                if(a[i][j]=='*')
                board[i][j]=1;
            }
        }
        int b[][]=new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
                b[i][j]=board[i][j];
            }
        }

        for (int i = 0; i < 8; i++) {
            boolean solved=SolveNQ(i);
            if(solved)count++;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k <8 ; k++) {
                    board[j][k]=b[j][k];
                }
            }
        }

        System.out.println(count);
    }
    static boolean SolveNQ(int row){
        if(row>=8)return true;

        for (int i = 0; i <8 ; i++) {
            if(isSafe(row,i)){
                board[row][i]=1;
                if(SolveNQ(row+1))return true;
                board[row][i]=0;
            }
        }
        return false;
    }
    static boolean isSafe(int row,int col){
        // check on board array
        if(board[row][col]!=0)return false;
        for(int i=row-1;i>=0;i--){
            if(board[i][col]!=0)return false;
        }
        for (int i = row-1,j=col-1; i >=0 && j>=0 ; i--,j--) {
            if(board[i][j]!=0)return false;
        }
        for (int i = row-1,j=col+1; i >=0 && j<8 ; i--,j++) {
            if(board[i][j]!=0)return false;
        }
        return true;
    }
}
// THIS CODE DOESNOT WORK