package Unit;

import java.awt.Rectangle;

public class Unit {
    //location
    int x,y;
    public int status; //rozroznia rodzaj jednostki
    public Unit(){
        x=(int)(Math.random()*790+0);
        y=(int)(Math.random()*590+0);
    }
    public Rectangle getBounds() {
        return new Rectangle(x-5, y+5, 10, 10);
    }
    public int getStatus(){
        return status;
    }
    //dla testu
    public static void collision(Unit u1, Unit u2, Unit u3){
        Rectangle unit1 = u1.getBounds();
        Rectangle unit2 = u2.getBounds();
        Rectangle unit3 = u3.getBounds();
        if(unit1.intersects(unit2)){
            if(u1.status==1 && u2.status==2){
                u2.status=0;
            }
        else if(unit2.intersects(unit3))
            if(u2.status==2 && u3.status==3){
                u3.status=0;
            }
        else if(unit3.intersects(unit1))
            if(u3.status==3 && u1.status==1){
                u1.status=0;
            }
        }
    }
}