package Unit;
public class Knight extends Unit {
    //velocity
    static int vxK, vyK;
    public Knight(){
        vxK=(int)(Math.random()*(50+1)+-25);
        vyK=(int)(Math.random()*(50+1)+-25);
    }
    /*public static void getMoveKnight(int x, int y){
        x+=vxK;
        y+=vyK;
    }*/
}