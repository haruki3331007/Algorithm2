import java.util.ArrayList;

public class Node {
    ArrayList<Integer> pi=new ArrayList<Integer>();
    int d;
    Node v;

    Node(){}

    void setD(int d){
        this.d=d;
    }

    void setV(Node v){
        this.v=v;
    }


}
