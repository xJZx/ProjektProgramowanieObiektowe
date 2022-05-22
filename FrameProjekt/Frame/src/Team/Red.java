package Team;

import Unit.Unit;
import Unit.Knight;
import Unit.Swordsman;
import Unit.Pikeman;

import java.util.Scanner;
import java.util.ArrayList;

public class Red extends Team{
    static ArrayList<Unit> Army2 = new ArrayList<Unit>();
    public static void teamSelectorRed() {
        Scanner scanner = new Scanner(System.in);
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
        scanner.close(); 
    }
}
