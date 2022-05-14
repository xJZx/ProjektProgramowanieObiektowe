package Unit;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Unit {
    //location
    int x,y,status;
    boolean visible;
    public Unit(){
        x=(int)(Math.random()*790+0);
        y=(int)(Math.random()*590+0);
        status=1;
        visible=true;
    }
    /*public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 10);
    }*/
    //dla testu
    public void collision(Unit u2, ArrayList<Knight> Army1, ArrayList<Swordsman> Army2){
        Rectangle unit1 = new Rectangle(u2.x, u2.y, 10,10);
        Rectangle unit2 = new Rectangle(this.x, this.y, 10,10);

        if(unit1.intersects(unit2)){
            if(unit1 instanceof Knight && unit2 instanceof Swordsman){
                unit2.x=1000;
                unit2.y=1000;
            }
        }
    }
}