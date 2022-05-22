package Team;

import Unit.Unit;
import Unit.Knight;
import Unit.Swordsman;
import Unit.Pikeman;

import java.util.Scanner;
import java.util.ArrayList;

public class Blue extends Team{
    static ArrayList<Unit> Army1 = new ArrayList<Unit>();
    public static void teamSelectorBlue() {
        System.out.println("Select team preset: ");
        Scanner scanner = new Scanner(System.in);
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
        scanner.close(); 
    }
}
