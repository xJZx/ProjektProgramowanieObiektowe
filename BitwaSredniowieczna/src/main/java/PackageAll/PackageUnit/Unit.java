package PackageAll.PackageUnit;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Klasa Unit
 */
public class Unit {
    /**
     * zmienna zawierajaca lokalizacje unitow
     */
    protected int x,y;
    /**
     * zmienna rozrozniajaca rodzaj jednostki
     */
    protected int status;
    /**
     * zmienna zawierajaca licznik zabojstw dla Blue i Red
     */
    protected int killCounter=0;

    /**
     * Konstruktor Unita
     */
    public Unit(){
        x=(int)(Math.random()*790+0);
        y=(int)(Math.random()*590+0);
    }

    /**
     * metoda na hitboxy unitow
     */
    private Rectangle getBounds() {
        return new Rectangle(x-5, y+5, 10, 10);
    }


    /**
     * getter na status
     */
    public int getStatus(){
        return status;
    }

    /**
     *
     * getter na killCounter
     */
    public int getKillCounter(){
        return killCounter;
    }

    /**
     * metoda ktora rozroznia przypadki dla kolizji
     * @param u1 jedna jednostka
     * @param u2 druga jednostka
     * @param Army1 ArrayList z ktorego pochodzi pierwsza jednostka
     * @param Army2 ArrayList z ktorego pochodzi druga jednostka
     */
    public void collision(Unit u1, Unit u2, ArrayList Army1, ArrayList Army2){ //kolejnosc parametrow ma znaczenie ;)
        Rectangle unit1 = u1.getBounds();
        Rectangle unit2 = u2.getBounds();
        if(unit1.intersects(unit2)){
            if(u1.status==1 && u2.status==2){ //Knight i Swordsman
                Army2.remove(u2);
                killCounter++;
            }
            else if(u1.status==2 && u2.status==3){ //Swordsman i Pikeman
                Army2.remove(u2);
                killCounter++;
            }
            else if(u1.status==3 && u2.status==1){ //Pikeman i Knight
                Army2.remove(u2);
                killCounter++;
            }
            else if(u1.status==u2.status){ //ten sam rodzaj jednostki
                double fight=Math.random();
                if(fight>=0.5){
                    Army1.remove(u1);
                    killCounter++;
                }
                else if(fight<0.5){
                    Army2.remove(u2);
                    killCounter++;
                }
            }
        }
    }
}