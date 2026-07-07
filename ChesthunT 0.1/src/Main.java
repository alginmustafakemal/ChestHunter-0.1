import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;


public class Main {
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

        alan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                boolean hareketEtti = false;

                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                    cr.setLocation(cr.getX(), cr.getY() - 60);
                    if (cr.getY() < 0) cr.setLocation(cr.getX(), 360);
                    hareketEtti = true;
                } else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                    cr.setLocation(cr.getX() - 60, cr.getY());
                    if (cr.getX() < 0) cr.setLocation(360, cr.getY());
                    hareketEtti = true;
                } else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                    cr.setLocation(cr.getX(), cr.getY() + 60);
                    if (cr.getY() >= 420) cr.setLocation(cr.getX(), 0);
                    hareketEtti = true;
                } else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                    cr.setLocation(cr.getX() + 60, cr.getY());
                    if (cr.getX() >= 420) cr.setLocation(0, cr.getY());
                    hareketEtti = true;
                }

                if (hareketEtti == true) {
                    mv.moving(poi);
                    moveRight.setText("" + mv.getMr());

                    for (int i = 0; i < chests.length; i++) {
                        if (cr.getX() == chestButtons[i].getX() && cr.getY() == chestButtons[i].getY()) {
                            chests[i].setter();
                            chestButtons[i].setLocation(chests[i].getXc(), chests[i].getYc());
                            poi.gettingPoint();
                            Gamescore.setText("Puan: " + poi.getPoint());
                        }
                    }
                }
            }
        });



        for(int i=0;i<chests.length;i++) {
            if (cr.getX() == chestButtons[i].getX() && cr.getY() == chestButtons[i].getY()) {
                chests[i].setter();
                chestButtons[i].setLocation(chests[i].getXc(), chests[i].getYc());
                poi.gettingPoint();
                Gamescore.setText("Puan: " + poi.getPoint());
            }
        }

        keyboard.add(moveRight);
        keyboard.add(Gamescore);


        alan.add(cr);
        for (int i=0;i<chestButtons.length;i++){
            alan.add(chestButtons[i]);
        }
        alan. setVisible(true);
        keyboard.setVisible(true);
        alan.setFocusable(true);
        alan.requestFocusInWindow();


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
