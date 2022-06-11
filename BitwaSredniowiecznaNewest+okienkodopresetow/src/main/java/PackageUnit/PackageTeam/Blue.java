package PackageUnit.PackageTeam;

import java.util.Scanner;

import PackageUnit.Knight;
import PackageUnit.Pikeman;
import PackageUnit.Swordsman;
import PackageUnit.Unit;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Blue extends Team{
    public ArrayList<Unit> Army1 = new ArrayList<Unit>();
    Scanner scanner = new Scanner(System.in);
    public void teamSelectorBlue(int selector) {
        switch(selector){
            case 1:
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    Army1.add(new Knight());
                }
                for(int i=0; i<10; i++){
                    Army1.add(new Swordsman());
                    Army1.add(new Pikeman());
                }
                break;
            case 2:
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    Army1.add(new Swordsman());
                }
                for(int i=0; i<10; i++){
                    Army1.add(new Knight());
                    Army1.add(new Pikeman());
                }
                break;
            case 3:
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    Army1.add(new Pikeman());
                }
                for(int i=0; i<10; i++){
                    Army1.add(new Knight());
                    Army1.add(new Swordsman());
                }
                break;
        }
    }
    //metoda paintBlue / paintRed tak jak w Unitach ale z większą ilościa statusów dla ktorych ta sama farba będzie
    public void paintBlue(Graphics g, ArrayList<Unit> Army1) {
        switch(getStatus()){
            case 0:
                g.setColor(Color.WHITE);
            case 1:
                g.setColor(Color.BLUE);
            case 2:
                g.setColor(Color.BLUE);
            case 3:
                g.setColor(Color.BLUE);
        }
    }
}
