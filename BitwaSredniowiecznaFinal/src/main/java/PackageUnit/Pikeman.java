package PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

public class Pikeman extends Unit {
    private int vxP, vyP;   //prędkość unitow
    private int signPx=1, signPy=1; //zmienne odpowiadajace za zwrot wektora prędkości

    public Pikeman(){   //konstruktor unita
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

    public void shapeP(Graphics g, ArrayList<Unit> Army){   //metoda na kształt unita
        g.fillRect(x,y,10,10);

        getMovePikeman();
    }
    private void getMovePikeman(){  //metoda odpowiadajaca za ruch unita
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