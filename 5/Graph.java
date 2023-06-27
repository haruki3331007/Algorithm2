import java.util.ArrayList;

public class Graph {
    int node;
    ArrayList<Integer> pi=new ArrayList<Integer>();
    int d;

    void setNode(int node){
        this.node=node;
    }
    
    @SuppressWarnings("unchecked")
    void setAdj(ArrayList<Integer> pi){
        this.pi = (ArrayList<Integer>)pi.clone();
    }

    void addAdj(int adj){
        pi.add(adj);
    }

    void setD(int d){
        this.d=d;
    }

    int getDis(){
        return d;
    }

    int getNode(){
        return node;
    }

    ArrayList<Integer> getPi(){
        return pi;
    }

    void printAdj(){
        for(int i=0; i<pi.size(); i++) System.out.print(pi.get(i) + " ");
    }

}
