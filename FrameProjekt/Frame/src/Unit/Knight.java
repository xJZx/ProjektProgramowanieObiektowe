package Unit;
import java.awt.Color;
import java.awt.Graphics;

public class Knight extends Unit {
    //velocity
    int vxK, vyK;
    public Knight(){
        vxK=(int)(Math.random()*(3+1)+-6);
        vyK=(int)(Math.random()*(3+1)+-6);
    }
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x,y,10,10);

        x+=vxK;
        y+=vyK;

        if(x<0 || x>=790){
            vxK*=-1;
        }
        if(y<0 || y>=590){
            vyK*=-1;
        }
    }
    /*public static void getMoveKnight(int x, int y){
        x+=vxK;
        y+=vyK;
    }*/
}