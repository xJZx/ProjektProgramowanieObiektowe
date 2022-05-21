package Unit;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Knight extends Unit {
    //velocity
    int vxK, vyK;
    public Knight(){
        vxK=(int)(Math.random()*(3+1)+-6);
        vyK=(int)(Math.random()*(3+1)+-6);
        status=1;
    }
    //dla testu
    public void paintK(Graphics g, ArrayList<Knight> Army1){
        switch(status){
            case 0:
                g.setColor(Color.WHITE);
            case 1:
                g.setColor(Color.BLUE);
        }
        g.fillOval(x,y,10,10);

        getMoveKnight();
    }
    public void getMoveKnight(){
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