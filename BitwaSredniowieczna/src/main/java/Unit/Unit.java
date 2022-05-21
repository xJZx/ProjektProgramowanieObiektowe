package Unit;

import java.awt.Rectangle;

public class Unit {
    //location
    protected int x,y;
    protected int status; //rozroznia rodzaj jednostki
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
                else if(unit1.intersects(unit3))
                    if(u1.status==1 && u3.status==3){
                        u1.status=0;
                    }
        }
    }
}
/*    public static void unitSpawner(){
        //no spawnuje jednostke xd
    }
    public static boolean isFight(){
        //czy jest (Red vs Red/Blue vs Blue) czy Blue vs Red?
        //jesli na danym polu spotkaja sie wiecej niz 2 jednostki, sprawdzamy ktorego zespolu jest wiecej ->
        // -> (wtedy ten wygrywa na danym polu, pozniej je trzeba rozdzielic na sasiadujace pola)
        return costam;
    }
    //jest 6 mozliwych scenariuszy pojedynku
    public static boolean isSpace(){
        //sprawdza czy przy kolejnym wykonaniu ruchu na polu nie stoi kamien
        return cos;
    }
*/
