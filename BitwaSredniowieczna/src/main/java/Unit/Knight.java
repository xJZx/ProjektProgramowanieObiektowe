package Unit;

import Unit.Unit;

public class Knight extends Unit {
    static int vxK, vyK;
    public Knight(){
        vxK=(int)(Math.random()*(50+1)+-25);
        vyK=(int)(Math.random()*(50+1)+-25);
    }
    public static void getMoveKnight(int x, int y){
        x+=Knight.vxK;
        y+=Knight.vyK;
    }
}
