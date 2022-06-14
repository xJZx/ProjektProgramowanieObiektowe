package PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

public class Knight extends Unit {
    private int vxK, vyK;   //prędkość unitow
    private int signKx=1, signKy=1; //zmienne odpowiadajace za zwrot wektora prędkości

    public Knight(){    //konstruktor unita
        if(Math.random()>0.5){
            signKx=-1;
        }
        if(Math.random()>0.5){
            signKy=-1;
        }
        vxK=(int)(Math.random()*(3+1)+1)*signKx;
        vyK=(int)(Math.random()*(3+1)+1)*signKy;
        status=1;
    }

    public void shapeK(Graphics g, ArrayList<Unit> Army){   //metoda na kształt unita
        g.fillArc(x,y,20,20,90,90);

        getMoveKnight();
    }
    private void getMoveKnight(){   //metoda odpowiadajaca za ruch unita
        x+=vxK;
        y+=vyK;

        if(x<0 || x>=790){
            vxK*=-1;
        }
        if(y<0 || y>=590){
            vyK*=-1;
        }
    }
}