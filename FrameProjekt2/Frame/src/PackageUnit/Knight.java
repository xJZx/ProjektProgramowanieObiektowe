package PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

public class Knight extends Unit {
    //velocity
    private int vxK, vyK;
    public Knight(){
        vxK=(int)(Math.random()*(2+1)+-3);
        vyK=(int)(Math.random()*(2+1)+-3);
        status=1;
    }
    //dla testu
    public void shapeK(Graphics g, ArrayList<Unit> Army){
        g.fillArc(x,y,20,20,90,90);

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