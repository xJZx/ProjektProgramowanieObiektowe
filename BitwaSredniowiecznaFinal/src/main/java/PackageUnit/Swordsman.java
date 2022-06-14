package PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

public class Swordsman extends Unit {
    private int vxS, vyS;   //prędkość unitow
    private int signSx=1, signSy=1; //zmienne odpowiadajace za zwrot wektora prędkości

    public Swordsman(){ //konstruktor unita
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

    public void shapeS(Graphics g, ArrayList<Unit> Army){   //metoda na kształt unita
        g.fillOval(x,y,10,10);

        getMoveSwordsman();
    }
    private void getMoveSwordsman(){    //metoda odpowiadajaca za ruch unita
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