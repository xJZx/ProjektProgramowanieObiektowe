package PackageNature;

import PackageUnit.Knight;
import PackageUnit.Swordsman;
import PackageUnit.Unit;
import PackageUnit.Pikeman;

import java.awt.*;
import java.util.ArrayList;

public class Stone extends Nature {
    public ArrayList<Stone> Stones = new ArrayList<>();
    int x,y;

    Knight knight = new Knight();
    Swordsman swordsman = new Swordsman();
    Pikeman pikeman = new Pikeman();

    public Stone(){
        x=(int)(Math.random()*790+0);
        y=(int)(Math.random()*590+0);
    }

    public Rectangle getBoundsStone(){
        return new Rectangle(x-5, y+5, 10, 10);
    }

    public void paintS(Graphics g, ArrayList<Stone> Stones){
        g.setColor(Color.GRAY);
        g.fillOval(x,y,10,10);
    }

    public void makeStones(){
        for (int i = 0; i < 10; i++) {
            Stones.add(new Stone());
        }
    }

    public void collisionStone(Unit u, Stone s){
        Rectangle unit = u.getBoundsUnit();
        Rectangle stone = s.getBoundsStone();

        if(unit.intersects(stone)){
            if(u.getStatus()==1){
                knight.vxK*=-1;
                knight.vyK*=-1;
            }

            else if(u.getStatus()==2){
                swordsman.vxS*=-1;
                swordsman.vyS*=-1;
            }

            else if(u.getStatus()==3){
                pikeman.vxP*=-1;
                pikeman.vyP*=-1;
            }
        }
    }
}
