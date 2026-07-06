import java.util.Random;

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
