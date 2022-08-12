package PackageAll.PackageUnit;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * klasa Pikeman
 */
public class Pikeman extends Unit {
    /**
     * zmienna odpowiadajaca za predkosc Pikemanow
     */
    private int vxP, vyP;
    /**
     * zmienna odpowiadajaca za zwrot wektora predkosci Pikemanow
     */
    private int signPx=1, signPy=1;

    /**
     * Konstruktor Pikemana
     */
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

    /**
     * metoda na ksztalt Pikemana
     *
     */
    public void shapeP(Graphics g, ArrayList<Unit> Army){
        g.fillRect(x,y,10,10);

        getMovePikeman();
    }

    /**
     * metoda na poruszanie sie Pikemana
     */
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