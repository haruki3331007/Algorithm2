import java.util.*;

class Floyd{
    public static int inf=100000;

    public static int[][] FLOYD(int[][] w){
        int n = w.length;
        int[][] D = copyArray(w);

        for(int k=0; k<n; k++)
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);

        return D;
    }

    public static int[][] copyArray(int[][] w){
        int n=w.length;
        int[][] copy = new int[n][n];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) copy[i][j] = w[i][j];

        return copy;
    }

    public static void main(String[] args){
        System.out.println("Input the number of nodes.");
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int[][] w=new int[H][H]; 
        for(int i=0; i<H; i++)
            for(int j=0; j<H; j++) {
                if(i==j) w[i][j]=0;
                else w[i][j]=inf;
            }

        System.out.println("Input the number of edges.");
        int input = scanner.nextInt();

        System.out.println("Input the information of");
        System.out.println("1.first node 2.second node 3.edge's weght.");
        
        for(int i=0; i<input; i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            int dis = scanner.nextInt();

            w[s][e]=dis;
        } 

        int[][] D = FLOYD(w);

        System.out.println();
        System.out.println("This is the first weight");
        System.out.println();
        for(int i=0; i<H; i++) {
            for(int j=0; j<H; j++){
                if(w[i][j]==inf) System.out.print("inf ");
                else System.out.print(w[i][j] + " ");
            }
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
