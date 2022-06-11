import javax.swing.*;

import PackageUnit.Knight;
import PackageUnit.Pikeman;
import PackageUnit.Swordsman;
import PackageUnit.Unit;
import PackageUnit.PackageTeam.Blue;
import PackageUnit.PackageTeam.Red;
import PackageNature.Stone;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JPanel implements ActionListener {

    public static void main(String[] arg){
        MainFrame f = new MainFrame();
    }

    Blue blue = new Blue(); //dziwne obiekty, zeby nie bylo static'ow
    Red red = new Red();
    Unit unit = new Unit();
    Stone stone = new Stone();

    public MainFrame(){ //konstruktor na okno aplikacji
        JFrame frame = new JFrame("Simulation");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        blue.teamSelectorBlue();    //metoda wybierajaca preset armii
        red.teamSelectorRed();
        stone.makeStones(); //metoda dodajaca kamienie

        Timer timer = new Timer(10,this);   //odswiezanie ekranu w ms
        timer.restart();

        frame.add(this);

        frame.setVisible(true);
    }

    public void paint(Graphics g){  //metoda od grafiki
        super.paintComponent(g);
        for(Unit u1: blue.Army1){
            blue.paintBlue(g, blue.Army1);  //metoda przydzielajaca kolor unitom
            if(u1.getStatus()==1){
                ((Knight) u1).shapeK(g, blue.Army1);
            }
            if(u1.getStatus()==2){
                ((Swordsman) u1).shapeS(g, blue.Army1);
            }
            if(u1.getStatus()==3){
                ((Pikeman) u1).shapeP(g, blue.Army1);
            }
        }
        for(Unit u2: red.Army2){
            red.paintRed(g, red.Army2); //metoda przydzielajaca kolor unitom
            if(u2.getStatus()==1){
                ((Knight) u2).shapeK(g, red.Army2);
            }
            if(u2.getStatus()==2){
                ((Swordsman) u2).shapeS(g, red.Army2);
            }
            if(u2.getStatus()==3){
                ((Pikeman) u2).shapeP(g, red.Army2);
            }
        }

        for(Stone s: stone.Stones){
            s.paintS(g,stone.Stones);
        }

        for(int i=0; i<blue.Army1.size(); i++) { //przeszukiwanie arrayow za kolizja
            for(int j=0; j<red.Army2.size(); j++){
                unit.collision(blue.Army1.get(i), red.Army2.get(j));
            }
        }
        for(int i=0; i<red.Army2.size(); i++) { //przeszukiwanie arrayow za kolizja
            for(int j=0; j<blue.Army1.size(); j++){
                unit.collision(red.Army2.get(i), blue.Army1.get(j));
            }
        }

        for (int i = 0; i < red.Army2.size(); i++) {
            for (int j = 0; j < stone.Stones.size(); j++) {
                stone.collisionStone(red.Army2.get(i), stone.Stones.get(j));
            }
        }

        for (int i = 0; i < blue.Army1.size(); i++) {
            for (int j = 0; j < stone.Stones.size(); j++) {
                stone.collisionStone(blue.Army1.get(i), stone.Stones.get(j));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}