package PackageAll.PackageTeam;

import PackageAll.PackageUnit.Knight;
import PackageAll.PackageUnit.Pikeman;
import PackageAll.PackageUnit.Swordsman;
import PackageAll.PackageUnit.Unit;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Klasa Blue
 */
public class Blue{
    /**
     * ArrayList z jednostkami teamu niebieskiego
     */
    public ArrayList<Unit> ArmyBlue = new ArrayList<Unit>();

    /***
     * metoda wybierajaca preset dla teamu niebieskiego
     * @param selector parametr wybierania
     */
    public void teamSelectorBlue(int selector) {
        switch(selector){
            case 1: //preset zawierajacy wiecej Knightow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyBlue.add(new Knight());
                }
                for(int i=0; i<10; i++){
                    ArmyBlue.add(new Swordsman());
                    ArmyBlue.add(new Pikeman());
                }
                break;
            case 2: //preset zawierajacy wiecej Swordsmanow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyBlue.add(new Swordsman());
                }
                for(int i=0; i<10; i++){
                    ArmyBlue.add(new Knight());
                    ArmyBlue.add(new Pikeman());
                }
                break;
            case 3: //preset zawierajacy wiecej Pikemanow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyBlue.add(new Pikeman());
                }
                for(int i=0; i<10; i++){
                    ArmyBlue.add(new Knight());
                    ArmyBlue.add(new Swordsman());
                }
                break;
        }
    }

    /**
     *  metoda na kolorowanie unitow teamu niebieskiego
     *
     */
    public void paintBlue(Graphics g, ArrayList<Unit> Army1) {
        g.setColor(Color.BLUE);
    }
}
