package Unit;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Swordsman extends Unit {
    //velocity
    int vxS, vyS;
    public Swordsman(){
        vxS=(int)(Math.random()*(1+1)+-2);
        vyS=(int)(Math.random()*(1+1)+-2);
    }
    //dla testu
    public void paintS(Graphics g, ArrayList<Swordsman> Army2){
        /*switch(status){
            case 0:
                Army2.remove(g);
            case 1:
                g.setColor(Color.RED);
        }*/
        g.setColor(Color.RED);
        g.fillOval(x,y,10,10);

        x+=vxS;
        y+=vyS;

        if(x<0 || x>=790){
            vxS*=-1;
        }
        if(y<0 || y>=590){
            vyS*=-1;
        }
    }
    /*public static void getMoveKnight(int x, int y){
        x+=vxK;
        y+=vyK;
    }*/
}