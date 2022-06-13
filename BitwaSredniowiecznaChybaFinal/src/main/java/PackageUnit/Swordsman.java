package PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

public class Swordsman extends Unit {
    //velocity
    private int vxS, vyS;
    private int signSx=1, signSy=1;
    public Swordsman(){
        if(Math.random()>0.5){
            signSx=-1;
        }
        if(Math.random()>0.5){
            signSy=-1;
        }
        vxS=(int)(Math.random()*(2+1)+1)*signSx;
        vyS=(int)(Math.random()*(2+1)+1)*signSy;
        status=2;
    }
    //dla testu
    public void shapeS(Graphics g, ArrayList<Unit> Army){
        g.fillOval(x,y,10,10);

        getMoveSwordsman();
    }
    private void getMoveSwordsman(){
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