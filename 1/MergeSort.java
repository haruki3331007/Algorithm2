import java.util.*;

class MergeSort {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        List<Integer> A = new ArrayList<Integer>();

        int input = scan.nextInt();
        for(int i=0; i<input; i++) A.add(scan.nextInt());

        Merge_Sort m = new Merge_Sort();
        A=m.merge_sort(A);
        for(int i=0; i<input; i++) System.out.print(A.get(i) + " ");

    }
}

class Merge_Sort{
    List<Integer> merge_sort(List<Integer> A){
        System.out.println("A.size "+ A.size());

            int middle = A.size()/2;

            List<Integer> left = new ArrayList<Integer>();
            for(int i=0; i<middle; i++) {left.add(A.get(i)); System.out.print(A.get(i) + " ");}
            System.out.println();
            if(left.size()>=2)left = merge_sort(left);
    
            List<Integer> right = new ArrayList<Integer>();
            for(int i=middle; i<A.size(); i++) {right.add(A.get(i));System.out.print(A.get(i) + " ");}
            System.out.println();
            if(right.size()>=2)right = merge_sort(right);
        
        return merge(left, right);
    } 

    List<Integer> merge (List<Integer> A, List<Integer> B){
        int flaga=0;
        int flagb=0;

        List<Integer> result = new ArrayList<Integer>();

        while (A.size() >flaga || B.size() > flagb) {
            if (A.size() > flaga && B.size() > flagb) {
                if (A.get(flaga) <= B.get(flagb)) {result.add(A.get(flaga)); flaga++;}
                else {result.add(B.get(flagb)); flagb++;}
            }
            else if (A.size() > flaga) {result.add(A.get(flaga)); flaga++;}
            else if (B.size() > flagb) {result.add(B.get(flagb)); flagb++;}
        }
        return result;
    }

}