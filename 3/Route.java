import java.util.*;

//WHITE = 0
//GRAY  = 1
//BLACK = 2
class Route{
    public static int time;

    public static void DFS(Point[] G, int[][] M){
        // initialization
        for(int i=0; i<G.length; i++)G[i].Color(0);

        time = 0;

        // visit each node
        for(int i=0; i<G.length; i++) {
            if(G[i].color==0) DFSVisit(G, G[i], i, M);
        }
    }

    public static void DFSVisit(Point[] G, Point u, int now, int[][] M){
        time++;

        u.DisTime(time);
        u.Color(1);

        for(int i=0; i<G.length; i++){
            if(G[i].color==0 && M[now][i]==1) DFSVisit(G, G[i], i, M);
        }
        u.color = 2;
        time++;
        u.FinTime(time);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();

        Point[] G = new Point[H];
        for(int i=0; i<H; i++) G[i]=new Point();

        int[][] M = new int[H][H];
        for(int i=0; i<H; i++) for(int j=0; j<H; j++) M[i][j]=0;

        int input = scanner.nextInt();
        for(int i=0; i<input; i++){
            int h = scanner.nextInt();
            int w = scanner.nextInt();

            M[h][w]=1;
        }

        DFS(G, M);

        for(int i=0; i<H; i++){
                //if()
                System.out.print("i : " + i );
                G[i].Print();
        }
    }
}
