package PackageAll.PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * klasa Swordsman
 */
public class Swordsman extends Unit {
    /**
     * zmienna odpowiadajaca za predkosc Swordsmanow
     */
    private int vxS, vyS;
    /**
     * zmienna odpowiadajaca za zwrot wektora predkosci Swordsmanow
     */
    private int signSx=1, signSy=1;

    /**
     * Konstruktor Swordsmana
     */
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

    /**
     * metoda na ksztalt Swordsmana
     *
     */
    public void shapeS(Graphics g, ArrayList<Unit> Army){   //metoda na kształt unita
        g.fillOval(x,y,10,10);

        getMoveSwordsman();
    }

    /**
     * metoda na poruszanie sie Swordsmana
     */
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