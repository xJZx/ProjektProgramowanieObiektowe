import Unit.Unit;
import Unit.Knight;
import Unit.Swordsman;
import Unit.Pikeman;

import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Team {
    public static ArrayList<Unit> Army1 = new ArrayList<Unit>();
    public static ArrayList<Unit> Army2 = new ArrayList<Unit>();
    static Scanner scanner = new Scanner(System.in);

    public static void teamSelectorBlue() {
        System.out.println("Select team Blue preset: ");
        int selector = scanner.nextInt();
        switch(selector){
            case 1:
                //wypelnianie tablic jednostkami
                for(int i=0; i<50; i++){
                    Army1.add(new Knight());
                }
                for(int i=0; i<25; i++){
                    Army1.add(new Swordsman());
                    Army1.add(new Pikeman());
                }
            case 2:
                //wypelnianie tablic jednostkami
                for(int i=0; i<50; i++){
                    Army1.add(new Swordsman());
                }
                for(int i=0; i<25; i++){
                    Army1.add(new Knight());
                    Army1.add(new Pikeman());
                }
            case 3:
                //wypelnianie tablic jednostkami
                for(int i=0; i<50; i++){
                    Army1.add(new Pikeman());
                }
                for(int i=0; i<25; i++){
                    Army1.add(new Knight());
                    Army1.add(new Swordsman());
                }
        }
    }
    //metoda paintBlue / paintRed tak jak w Unitach ale z większą ilościa statusów dla ktorych ta sama farba będzie
    public void PaintBlue(Graphics g, ArrayList<Unit> Army) {
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
    public void PaintRed(Graphics g, ArrayList<Unit> Army) {
        switch(status){
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

    public static void teamSelectorRed() {
        System.out.println("Select team Red preset: ");
        int selector = scanner.nextInt();
        switch(selector){
            case 1:
                //wypelnianie tablic jednostkami
                for(int i=0; i<50; i++){
                    Army2.add(new Knight());
                }
                for(int i=0; i<25; i++){
                    Army2.add(new Swordsman());
                    Army2.add(new Pikeman());
                }
            case 2:
                //wypelnianie tablic jednostkami
                for(int i=0; i<50; i++){
                    Army2.add(new Swordsman());
                }
                for(int i=0; i<25; i++){
                    Army2.add(new Knight());
                    Army2.add(new Pikeman());
                }
            case 3:
                //wypelnianie tablic jednostkami
                for(int i=0; i<50; i++){
                    Army2.add(new Pikeman());
                }
                for(int i=0; i<25; i++){
                    Army2.add(new Knight());
                    Army2.add(new Swordsman());
                }
        }
    }
    /*public static void teamSelector() {
        System.out.println("Select team colour: 1-Blue/2-Red");
        Scanner scanner = new Scanner(System.in);
        int selector = scanner.nextInt();
        switch(selector){
            case 1:
                Blue.teamSelectorBlue();
            case 2:
                Red.teamSelectorRed();
        }
        scanner.close(); 
    }*/
}
