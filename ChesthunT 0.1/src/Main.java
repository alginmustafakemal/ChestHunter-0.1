import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

class Gamepoint{
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

class move{
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

class chest{
    Random rg=new Random();
    private int[] aralik={0,60,120,180,240,300,360};
    private int s1=rg.nextInt(aralik.length);
    private int s2=rg.nextInt(aralik.length);
    private int xc;
    private int yc;
    public chest(){
        this.xc=aralik[s1];
        this.yc=aralik[s2];
    }

    public void setter(){
        int[] aralik2={0,60,120,180,240,300,360};
        int s3=rg.nextInt(aralik2.length);
        int s4=rg.nextInt(aralik2.length);
        xc=aralik2[s3];
        yc=aralik2[s4];
    }

    public int getXc() {return xc;}
    public int getYc() {return yc;}
    public void setYc(int y){yc=y;}
    public void setXc(int x){xc=x;}
}

public class swing2 {
    public static void play(int num) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        Gamepoint poi=new Gamepoint();
        move mv=new move();

        chest[] chests=new chest[num];
        for (int i=0;i<chests.length;i++){
            chests[i]= new chest();
        }


        JFrame alan=new JFrame("");
        alan.setSize(434,458);
        alan.setLayout(null);
        alan.getContentPane().setBackground(new Color(100,200,100));

        JFrame keyboard=new JFrame("kb");
        keyboard.setSize(220,130);
        keyboard.setLayout(null);
        keyboard.getContentPane().setBackground(new Color(30,30,30));

        JButton cr=new JButton("Cr");
        cr.setBounds(0,0,60,60);

        JButton[] chestButtons=new JButton[num];
        for(int i=0;i<chestButtons.length;i++){
            chestButtons[i]=new JButton("***");
            chestButtons[i].setBounds(chests[i].getXc(),chests[i].getYc(),60,60);
        }

        JLabel Gamescore=new JLabel("Puaniniz: 0");
        Gamescore.setBounds(135,0,70,45);
        Gamescore.setForeground(Color.BLACK);
        Gamescore.setBackground(Color.WHITE);
        Gamescore.setOpaque(true);

        JLabel moveRight=new JLabel("30",SwingConstants.CENTER);
        moveRight.setBounds(135,45,70,45);
        moveRight.setForeground(Color.BLACK);
        moveRight.setBackground(Color.WHITE);
        moveRight.setOpaque(true);

        for(int i=0;i<chests.length;i++) {
            if (cr.getX() == chestButtons[i].getX() && cr.getY() == chestButtons[i].getY()) {
                chests[i].setter();
                chestButtons[i].setLocation(chests[i].getXc(), chests[i].getYc());
                poi.gettingPoint();
                Gamescore.setText("Puan: " + poi.getPoint());
            }
        }
        JButton w=new JButton("w");
        w.setBounds(45,0,45,45);
        w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cr.setLocation(cr.getX(),cr.getY()-60);
                mv.moving(poi);
                moveRight.setText(""+mv.getMr());
                for(int i=0;i<chests.length;i++){
                    if(cr.getX()==chestButtons[i].getX() && cr.getY()==chestButtons[i].getY()){
                        chests[i].setter();
                        chestButtons[i].setLocation(chests[i].getXc(),chests[i].getYc());
                        poi.gettingPoint();
                        Gamescore.setText("Puan: "+poi.getPoint());
                    }
                    if(cr.getY()<0){
                        cr.setLocation(cr.getX(),360);
                    }
                }
            }
        });

        JButton d=new JButton("d");
        d.setBounds(90,45,45,45);
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cr.setLocation(cr.getX()+60,cr.getY());
                mv.moving(poi);
                moveRight.setText(""+mv.getMr());
                for(int i=0;i<chests.length;i++){
                    if(cr.getX()==chestButtons[i].getX() && cr.getY()==chestButtons[i].getY()){
                        chests[i].setter();
                        chestButtons[i].setLocation(chests[i].getXc(),chests[i].getYc());
                        poi.gettingPoint();
                        Gamescore.setText("Puan: "+poi.getPoint());
                    }
                    if(cr.getX()>=420){
                        cr.setLocation(0,cr.getY());
                    }
                }
            }
        });

        JButton s=new JButton("s");
        s.setBounds(45,45,45,45);
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cr.setLocation(cr.getX(),cr.getY()+60);
                mv.moving(poi);
                moveRight.setText(""+mv.getMr());
                for(int i=0;i<chests.length;i++){
                    if(cr.getX()==chestButtons[i].getX() && cr.getY()==chestButtons[i].getY()){
                        chests[i].setter();
                        chestButtons[i].setLocation(chests[i].getXc(),chests[i].getYc());
                        poi.gettingPoint();
                        Gamescore.setText("Puan: "+poi.getPoint());
                    }
                    if(cr.getY()>=420){
                        cr.setLocation(cr.getX(),0);
                    }
                }
            }
        });

        JButton a=new JButton("a");
        a.setBounds(0,45,45,45);
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cr.setLocation(cr.getX()-60,cr.getY());
                mv.moving(poi);
                moveRight.setText(""+mv.getMr());
                for(int i=0;i<chests.length;i++){
                    if(cr.getX()==chestButtons[i].getX() && cr.getY()==chestButtons[i].getY()){
                        chests[i].setter();
                        chestButtons[i].setLocation(chests[i].getXc(),chests[i].getYc());
                        poi.gettingPoint();
                        Gamescore.setText("Puan: "+poi.getPoint());
                    }
                    if(cr.getX()<0){
                        cr.setLocation(360,cr.getY());
                    }
                }
            }
        });


        keyboard.add(moveRight);
        keyboard.add(Gamescore);
        keyboard.add(a);
        keyboard.add(s);
        keyboard.add(d);
        keyboard.add(w);

        alan.add(cr);
        for (int i=0;i<chestButtons.length;i++){
            alan.add(chestButtons[i]);
        }


        alan. setVisible(true);
        keyboard.setVisible(true);


    }

    public static void sett(){
        JFrame ls=new JFrame();
        ls.setSize(434,458);
        ls.setLayout(null);

        ls.setVisible(true);
    }

    public static void lobby(){

        JFrame lobby=new JFrame();
        lobby.setSize(434,458);
        lobby.setLayout(null);

        JButton initiator=new JButton("Play denge");
        initiator.setBounds(110,100,100,50);
        initiator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play(10);
            }
        });

        JButton strategic =new JButton("Play stratejik");
        strategic.setBounds(0,100,100,50);
        strategic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play(6);
            }
        });

        JButton chaos=new JButton("Play kaos");
        chaos.setBounds(220,100,100,50);
        chaos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play(20);
            }
        });

        JButton settings=new JButton("Settings");
        settings.setBounds(0,160,100,50);
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sett();
            }
        });

        lobby.add(chaos);
        lobby.add(strategic);
        lobby.add(initiator);
        lobby.add(settings);
        lobby.setVisible(true);
        lobby.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        lobby();
    }
}
