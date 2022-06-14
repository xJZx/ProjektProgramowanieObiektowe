package PackageUnit.PackageTeam;

import PackageUnit.Knight;
import PackageUnit.Pikeman;
import PackageUnit.Swordsman;
import PackageUnit.Unit;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Red{
    public ArrayList<Unit> ArmyRed = new ArrayList<Unit>();   //tablica z jednostkami

    public void teamSelectorRed(int selector) {     //metoda na wybieranie presetu dla danego teamu
        switch(selector){
            case 1: //wiecej Knightow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyRed.add(new Knight());
                }
                for(int i=0; i<10; i++){
                    ArmyRed.add(new Swordsman());
                    ArmyRed.add(new Pikeman());
                }
                break;
            case 2: //wiecej Swordsmanow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyRed.add(new Swordsman());
                }
                for(int i=0; i<10; i++){
                    ArmyRed.add(new Knight());
                    ArmyRed.add(new Pikeman());
                }
                break;
            case 3: //wiecej Pikemanow
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

    //metoda na kolorowanie unitow
    public void paintRed(Graphics g, ArrayList<Unit> Army2) {
        g.setColor(Color.RED);
    }
}
