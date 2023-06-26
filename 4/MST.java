import java.util.*;

class MST{
    static void KRUSKAL(int[] G, Point[] w){
        Array[] A=new Array[w.length];
        for(int i=0; i<G.length; i++){
            A[i]=new Array();
            A[i].Add(i);
        }

        for (int i = 0; i < w.length - 1; i++) {
            for (int j = w.length - 1; j > i; j--) {
                if (w[j - 1].dis > w[j].dis) {
                    int dis = w[j - 1].dis;
                    int s = w[j - 1].s;
                    int e = w[j - 1].e;

                    w[j - 1].change(w[j].s, w[j].e, w[j].dis);

                    w[j].change(s, e, dis);
                }
            }
        }

        for (int i = 0; i < w.length; i++) {
            if(A[w[i].s].search(w[i].e)==0){
                for(int j=0; j<A[w[i].s].EachA.size(); j++){
                    A[A[w[i].s].EachA.get(j)].Add(A[w[i].s].EachA);
                    A[A[w[i].s].EachA.get(j)].Add(A[w[i].e].EachA);
                    //System.out.print("今回のwは" + (A[w[i].s].EachA.get(j)+1) + "で、");
                    //A[A[w[i].s].EachA.get(j)].print();
                }
                for(int j=0; j<A[w[i].e].EachA.size(); j++){
                    A[A[w[i].e].EachA.get(j)].Add(A[w[i].s].EachA);
                    A[A[w[i].e].EachA.get(j)].Add(A[w[i].e].EachA);
                    //A[A[w[i].e].EachA.get(j)].add(w[i].s);
                    //A[A[w[i].e].EachA.get(j)].add(w[i].e);
                    //System.out.print("今回のwは" + (A[w[i].e].EachA.get(j)+1) + "で、");
                    //A[A[w[i].e].EachA.get(j)].print();
                }
                System.out.println("s = " + (w[i].s+1) + " and e = " + (w[i].e+1));
            }
        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();

        int[] G = new int[H];
        for(int i=0; i<H; i++) G[i]=0;

        int input = scanner.nextInt();
        Point[] w=new Point[input];

        for(int i=0; i<input; i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            int dis = scanner.nextInt();

            w[i]=new Point(s-1, e-1, dis);
        }

        KRUSKAL(G, w);

    }
}