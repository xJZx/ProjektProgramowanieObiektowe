package Team;

import java.util.Scanner;

public class Team {
    public void teamSelector() {
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
    }
}
