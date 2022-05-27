package PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

public class Swordsman extends Unit {
    //velocity
    public int vxS, vyS;
    public Swordsman(){
        vxS=(int)(Math.random()*(1+1)+-2);
        vyS=(int)(Math.random()*(1+1)+-2);
        status=2;
    }
    //dla testu
    public void shapeS(Graphics g, ArrayList<Unit> Army){
        g.fillOval(x,y,10,10);

        getMoveSwordsman();
    }
    public void getMoveSwordsman(){
        x+=vxS;
        y+=vyS;

        if(x<0 || x>=790){
            vxS*=-1;
        }
        if(y<0 || y>=590){
            vyS*=-1;
        }
    }
}