package PackageUnit;

import java.awt.Rectangle;

public class Unit {
    //location
    protected int x,y;
    protected int status; //rozroznia rodzaj jednostki
    protected int killCounter=0;  //licznik zabojstw dla Blue i Red
    //potrzebny counter dla Blue i Red (do napisu Victory!)
    public Unit(){
        x=(int)(Math.random()*790+0);
        y=(int)(Math.random()*590+0);
    }
    public Rectangle getBounds() {
        return new Rectangle(x-5, y+5, 10, 10);
    }
    public int getStatus(){ //getter na status
        return status;
    }
    public int getKillCounter(){ //getter na status
        return killCounter;
    }
    //dla testu
    public void collision(Unit u1, Unit u2){    //kolejnosc parametrow ma znaczenie ;)
        Rectangle unit1 = u1.getBounds();
        Rectangle unit2 = u2.getBounds();
        if(unit1.intersects(unit2)){
            if(u1.status==1 && u2.status==2){
                u2.status=0;
                killCounter++;
            }
            else if(u1.status==2 && u2.status==3){
                u2.status=0;
                killCounter++;
            }
            else if(u1.status==3 && u2.status==1){
                u2.status=0;
                killCounter++;
            }
        }
    }
}