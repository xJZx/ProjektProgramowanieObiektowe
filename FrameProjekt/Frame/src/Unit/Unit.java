package Unit;
import java.awt.Color;
import java.awt.Graphics;

public class Unit {
    //location
    int x,y;
    public Unit(){
        x=(int)(Math.random()*790+0);
        y=(int)(Math.random()*590+0);
        x+=Knight.vxK;
        y+=Knight.vyK;
    }
    //dla testu
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x,y,10,10);
    }
}