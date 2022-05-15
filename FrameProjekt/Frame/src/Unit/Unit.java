package Unit;

import java.awt.Rectangle;

public class Unit {
    //location
    int x,y;
    int status; //rozroznia rodzaj jednostki
    public Unit(){
        x=(int)(Math.random()*790+0);
        y=(int)(Math.random()*590+0);
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 10);
    }
    //dla testu
    public void collision(Unit u1, Unit u2){
        Rectangle unit1 = u1.getBounds();
        Rectangle unit2 = u2.getBounds(); 

        if(unit1.intersects(unit2)){
            if(u1.status==1 && u2.status==2){
                u2.status=0;
            }
        }
    }
}