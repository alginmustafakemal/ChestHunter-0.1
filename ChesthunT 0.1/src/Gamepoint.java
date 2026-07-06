 public class Gamepoint{
    private int point;
    public Gamepoint(){
        point=0;
    }

    public void setPoint(int a){point=a;}
    public int getPoint(){return point;}

    public void gettingPoint(){
        point+=10;

    }
}