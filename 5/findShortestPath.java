import java.util.*;

class findShortestPath{
    public static int inf=Integer.MAX_VALUE;
    public static void DIJKSTRA(Node[] G, int s, Point[] w){
        INIT_SS(G, s);
        ArrayList<Point> Q = MIN_PRIORITY_QUEUE(w);

        while(Q.size() != 0){
            Point u = EXTRACT_MIN(Q);

            for(int i=0; i<w.length; i++){
                if(w[i].getS() == u.getE())  RELAX(w[i].getS(), u.getE(), w);
                else if(w[i].getE() == u.getS()) RELAX(w[i].getE(), u.getS(), w);
            }
        }
    }
    public static void INIT_SS(Node[] G, int s){
        for(int i=0; i<G.length; i++){
            G[i]=new Node();

            G[i].setD(inf);
            G[i].setV(null);
        }
        G[s].setD(0);
    }

    public static ArrayList<Point> MIN_PRIORITY_QUEUE(Point[] A){
        int heapsize=A.length;
        ArrayList<Point> heap = new ArrayList<>();
        for(int i=0; i<heapsize; i++) heap.add(A[i]);
        for(int i=0; i<heapsize/2; i++){
            MinHeapify(heap, i);
        }
        return heap;
    }

    public static void MinHeapify(ArrayList<Point> A, int i){
        int l=i+1;
        int r=i+2;
        int min;

        if(l<=A.size() && A.get(l).getDis()<A.get(i).getDis()) min=l;
        else min=i;
        if(l<=A.size() && A.get(r).getDis()<A.get(min).getDis()) min=r;

        if(i!=min){
            Point flag=A.get(i);
            A.set(i, A.get(min));
            A.set(min, flag);
            MinHeapify(A, min);
        }
    }

    public static Point EXTRACT_MIN(ArrayList<Point> A){
        Point min = A.get(0);
        A.remove(0);
        MinHeapify(A, 0);
        return min;
    }

    public static void RELAX(Point u, Point v, Point[] w){
        if (v.getSis() > u.getDis() + w){

        }
v.d = u.d + w (u, v) v.  = u
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        Node[] G = new Node[H];

        int input = scanner.nextInt();
        Point[] w=new Point[input];

        for(int i=0; i<input; i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            int dis = scanner.nextInt();

            w[i]=new Point(s-1, e-1, dis);
        }   

    }
}

