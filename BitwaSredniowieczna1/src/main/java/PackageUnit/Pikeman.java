package PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

public class Pikeman extends Unit {
    //velocity
    public int vxP, vyP;
    int signPx=1, signPy=1;
    public Pikeman(){
        if(Math.random()>0.5){
            signPx=-1;
        }
        if(Math.random()>0.5){
            signPy=-1;
        }
        vxP=(int)(Math.random()*(2+1)+1)*signPx;
        vyP=(int)(Math.random()*(2+1)+1)*signPy;
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