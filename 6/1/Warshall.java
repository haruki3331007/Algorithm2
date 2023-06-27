import java.util.*;

class Warshall{
    public static int[][] WARSHALL(int[][] w){
        int n = w.length;
        int[][] T = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j || w[i][j]==1) T[i][j]=1;
                else T[i][j]=0;
            }
        }

        for(int k=0; k<n; k++)
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    T[i][j] = LogicalConnective(T[i][j], T[i][k], T[k][j]);

        return T;
    }

    public static int LogicalConnective(int a, int b, int c){
        if(a==1) return 1;
        else if(b==1 && c==1) return 1;
        return 0;
    }

    public static void main(String[] args){
        System.out.println("Input the number of nodes.");
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int[][] w=new int[H][H]; 
        for(int i=0; i<H; i++)
            for(int j=0; j<H; j++) {
                if(i==j) w[i][j]=1;
                else w[i][j]=0;
            }

        System.out.println("Input the number of edges.");
        int input = scanner.nextInt();

        System.out.println("Input the information of");
        System.out.println("1.first node 2.second node 3.edge's weght.");
        
        for(int i=0; i<input; i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();

            w[s][e]=1;
        } 

        int[][] D = WARSHALL(w);

        System.out.println();
        System.out.println("This is the first weight");
        System.out.println();
        for(int i=0; i<H; i++) {
            for(int j=0; j<H; j++)System.out.print(w[i][j] + " ");
            System.out.println();
        }

        System.out.println();
        System.out.println("This is the final distances using Floyd's Algorithm");
        System.out.println();
        for(int i=0; i<H; i++) {
            for(int j=0; j<H; j++)System.out.print(D[i][j] + " ");
            System.out.println();
        }
    }
}
