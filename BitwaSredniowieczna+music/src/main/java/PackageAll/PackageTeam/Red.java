package PackageAll.PackageTeam;

import PackageAll.PackageUnit.Knight;
import PackageAll.PackageUnit.Pikeman;
import PackageAll.PackageUnit.Swordsman;
import PackageAll.PackageUnit.Unit;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Klasa Red
 */
public class Red{
    /**
     * ArrayList z jednostkami teamu czerwonego
     */
    public ArrayList<Unit> ArmyRed = new ArrayList<Unit>();


    /***
     * metoda wybierajaca preset dla teamu czerwonego
     * @param selector parametr wybierania
     */
    public void teamSelectorRed(int selector) {
        switch(selector){
            case 1: //preset zawierajacy wiecej Knightow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyRed.add(new Knight());
                }
                for(int i=0; i<10; i++){
                    ArmyRed.add(new Swordsman());
                    ArmyRed.add(new Pikeman());
                }
                break;
            case 2: //preset zawierajacy wiecej Swordsmanow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyRed.add(new Swordsman());
                }
                for(int i=0; i<10; i++){
                    ArmyRed.add(new Knight());
                    ArmyRed.add(new Pikeman());
                }
                break;
            case 3: //preset zawierajacy wiecej Pikemanow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyRed.add(new Pikeman());
                }
                for(int i=0; i<10; i++){
                    ArmyRed.add(new Knight());
                    ArmyRed.add(new Swordsman());
                }
                break;
        }
    }

    /**
     *  metoda na kolorowanie unitow teamu czerwonego
     *
     */
    public void paintRed(Graphics g, ArrayList<Unit> Army2) {
        g.setColor(Color.RED);
    }
}
