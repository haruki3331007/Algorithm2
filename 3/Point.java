public class Point {
    int num=0;
    int color=0;
    int dt=0;
    int ft=0;

    void Number(){
        this.num=1;
    }

    void Color(int color){
        this.color=color;
    }

    void DisTime(int time){
        this.dt = time;
    }
    
    void FinTime(int time){
        this.ft = time;
    }

    void Print(){
        System.out.println(" discovery time : " + dt + " finishing time : " + ft);
    }
}
