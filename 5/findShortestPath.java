import java.util.*;

class findShortestPath{
    public static int inf=Integer.MAX_VALUE;

    public static void DIJKSTRA(Graph[] G, int s, int[][] w){
        INIT_SS(G, s);

        ArrayList<Graph> Q;
        Q = MIN_PRIORITY_QUEUE(G);

        while(Q.size() != 0){
            Graph u = EXTRACT_MIN(Q);

            for(int i=0; i<w.length; i++){
                if(w[u.getNode()][i]!=inf) {
                    RELAX(u, G[i], w);
                }
            }
        }
    }

    public static void INIT_SS(Graph[] G, int s){
        for(int i=0; i<G.length; i++){
            G[i]=new Graph();
            G[i].setNode(i);
            G[i].setD(inf);
            //G[i].setAdj(null);
        }
        G[s].setD(0);
    }

    public static ArrayList<Graph> MIN_PRIORITY_QUEUE(Graph[] A){
        int heapsize=A.length;
        ArrayList<Graph> heap = new ArrayList<>();
        for(int i=0; i<heapsize; i++) heap.add(A[i]);

        heapsize/=2;

        for(int i=0; i<heapsize; i++) MinHeapify(heap, i);
        return heap;
    }

    public static void MinHeapify(ArrayList<Graph> A, int i){
        int l=i+1;
        int r=i+2;
        int min=i;

        if(l<A.size()){if(A.get(l).getDis()<A.get(i).getDis()) min=l;}
        else min=i;
        if(r<A.size())if(A.get(r).getDis()<A.get(min).getDis()) min=r;

        if(i!=min){
            Graph flag=A.get(i);
            A.set(i, A.get(min));
            A.set(min, flag);
            MinHeapify(A, min);
        }
    }

    public static Graph EXTRACT_MIN(ArrayList<Graph> A){
        Graph min = A.get(0);
        A.remove(0);
        MinHeapify(A, 0);
        return min;
    }


    public static void RELAX(Graph u, Graph v, int[][] w){
        if (v.getDis() > u.getDis() + w[u.getNode()][v.getNode()]){
            v.setD(u.getDis() + w[u.getNode()][v.getNode()]);
            v.setAdj(u.getPi());
            v.addAdj(u.getNode());
        }
    }

    public static void main(String[] args){
        System.out.println("Input the number of nodes.");
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        Graph[] G = new Graph[H];    //Graph adj-list with 1-dim
        int[][] w=new int[H][H]; //weigh matrix(2-dim)

        for(int i=0; i<H; i++)
            for(int j=0; j<H; j++) w[i][j]=inf;

        System.out.println("Input the number of edges.");
        int input = scanner.nextInt();

        System.out.println("Input the information of");
        System.out.println("1.first node 2.second node 3.edge's weght.");
        
        for(int i=0; i<input; i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            int dis = scanner.nextInt();

            w[s][e]=w[e][s]=dis;
        } 

        System.out.println("Input the start node");
        int s = scanner.nextInt();

        DIJKSTRA(G, s, w);

        System.out.println();
        System.out.println("This is the final distances using Dijkstra's Algorithm");
        for(int i=0; i<H; i++) {
            System.out.println("node " + i + " : ");
            System.out.print("      distance => " + G[i].getDis());
            System.out.print("      path => ");
            G[i].printAdj(); 
            System.out.println();
        }
    }
}


