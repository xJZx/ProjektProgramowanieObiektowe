package PackageUnit.PackageTeam;

import java.util.Scanner;

import PackageUnit.Knight;
import PackageUnit.Pikeman;
import PackageUnit.Swordsman;
import PackageUnit.Unit;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Red extends Team{
    public ArrayList<Unit> Army2 = new ArrayList<Unit>();

    public void teamSelectorRed(int selector) {
        switch(selector){
            case 1:
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    Army2.add(new Knight());
                }
                for(int i=0; i<10; i++){
                    Army2.add(new Swordsman());
                    Army2.add(new Pikeman());
                }
                break;
            case 2:
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    Army2.add(new Swordsman());
                }
                for(int i=0; i<10; i++){
                    Army2.add(new Knight());
                    Army2.add(new Pikeman());
                }
                break;
            case 3:
                //wypelnianie tablic jednostkami
                for(int i=0; i<30; i++){
                    Army2.add(new Pikeman());
                }
                for(int i=0; i<10; i++){
                    Army2.add(new Knight());
                    Army2.add(new Swordsman());
                }
                break;
        }
    }

    public void paintRed(Graphics g, ArrayList<Unit> Army2) {
        g.setColor(Color.RED);
    }
}
