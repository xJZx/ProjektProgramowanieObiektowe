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
    public Rectangle getBoundsUnit() {
        return new Rectangle(x-5, y+5, 10, 10);
    }
    public int getStatus(){ //getter na status
        return status;
    }
    public int getKillCounter(){ //getter na status
        return killCounter;
    }
    //dla kolizji
    public void collision(Unit u1, Unit u2){    //kolejnosc parametrow ma znaczenie ;)
        Rectangle unit1 = u1.getBoundsUnit();
        Rectangle unit2 = u2.getBoundsUnit();
        if(unit1.intersects(unit2)){
            if(u1.status==1 && u2.status==2){
                u2.status=0;

            }
            else if(u1.status==2 && u2.status==3){
                u2.status=0;

            }
            else if(u1.status==3 && u2.status==1){
                u2.status=0;

            }
            else if(u1.status==u2.status){
                double fight=Math.random();
                if(fight>0.5){
                    u1.status=0;
                }
                else if(fight<=0.5){
                    u2.status=0;
                }
            }
        }
    }
}