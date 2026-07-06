import javax.swing.*;

public class move{
    private int mr;
    public move(){
        mr=30;
    }

    public void setMr(int a){mr=a;}
    public int getMr(){return mr;}

    public void moving(Gamepoint p){
        if (mr<=0){
            JOptionPane.showMessageDialog(null,"Oyun Bitti! Puanınız: " + p.getPoint());
            System.exit(0);
        }
        mr--;
    }
}
