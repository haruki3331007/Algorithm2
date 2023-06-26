public class Point {
    int s, e, dis;

    Point(int s, int e, int dis){
        this.s=s;
        this.e=e;
        this.dis=dis;
    }

    void change(int s, int e, int dis){
        this.s=s;
        this.e=e;
        this.dis=dis;
    }

    int getDis(){
        return dis;
    }

    int getS(){
        return s;
    }

    int getE(){
        return e;
    }
}
