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
    Scanner scanner = new Scanner(System.in);
    public void teamSelectorRed() {
        System.out.println("Select team Red preset: ");
        int selector = scanner.nextInt();
        switch(selector){
            case 1:
                //wypelnianie tablic jednostkami
                for(int i=0; i<1; i++){
                    Army2.add(new Knight());
                }
                for(int i=0; i<1; i++){
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
        switch(getStatus()){
            case 0:
                g.setColor(Color.WHITE);
            case 1:
                g.setColor(Color.RED);
            case 2:
                g.setColor(Color.RED);
            case 3:
                g.setColor(Color.RED);
        }
    }
}
