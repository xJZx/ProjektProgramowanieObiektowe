package PackageUnit.PackageTeam;

import PackageUnit.Knight;
import PackageUnit.Pikeman;
import PackageUnit.Swordsman;
import PackageUnit.Unit;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Blue{
    public ArrayList<Unit> ArmyBlue = new ArrayList<Unit>();   //tablica z jednostkami

    public void teamSelectorBlue(int selector) {    //metoda na wybieranie presetu dla danego teamu
        switch(selector){
            case 1: //wiecej Knightow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyBlue.add(new Knight());
                }
                for(int i=0; i<10; i++){
                    ArmyBlue.add(new Swordsman());
                    ArmyBlue.add(new Pikeman());
                }
                break;
            case 2: //wiecej Swordsmanow
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    ArmyBlue.add(new Swordsman());
                }
                for(int i=0; i<10; i++){
                    ArmyBlue.add(new Knight());
                    ArmyBlue.add(new Pikeman());
                }
                break;
            case 3: //wiecej Pikemanow
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

    //metoda na kolorowanie unitow
    public void paintBlue(Graphics g, ArrayList<Unit> Army1) {
        g.setColor(Color.BLUE);
    }
}
