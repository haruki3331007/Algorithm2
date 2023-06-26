import java.util.ArrayList;

public class Array {
    ArrayList<Integer> EachA=new ArrayList<Integer>();

    void Add(ArrayList point){
        for(int i=0; i<point.size(); i++){
            if(!EachA.contains(point.get(i)))EachA.add((Integer)point.get(i));
        }
    }

    void Add(int point){
        EachA.add(point);
    }

    int search(int point){
        if (EachA.contains(point)) return 1;
        return 0;
    }

    void print(){
        for(int i=0; i<EachA.size(); i++) System.out.print(EachA.get(i) + " ");
        System.out.println();
    }
}
