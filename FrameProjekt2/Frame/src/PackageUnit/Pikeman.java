package PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

public class Pikeman extends Unit {
    //velocity
    private int vxP, vyP;
    public Pikeman(){
        vxP=(int)(Math.random()*(1+1)+-2);
        vyP=(int)(Math.random()*(1+1)+-2);
        status=3;
    }
    //dla testu
    public void shapeP(Graphics g, ArrayList<Unit> Army){
        g.fillRect(x,y,10,10);

        getMovePikeman();
    }
    public void getMovePikeman(){
        x+=vxP;
        y+=vyP;

        if(x<0 || x>=790){
            vxP*=-1;
        }
        if(y<0 || y>=590){
            vyP*=-1;
        }
    }
}