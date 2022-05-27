import javax.swing.*;

import PackageUnit.Knight;
import PackageUnit.Pikeman;
import PackageUnit.Swordsman;
import PackageUnit.Unit;
import PackageUnit.PackageTeam.Blue;
import PackageUnit.PackageTeam.Red;
import PackageUnit.PackageTeam.Team;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JPanel implements ActionListener {
    //presety armii (trzeba je zapełnic jakos)
    /*ArrayList<Knight> Army1 = new ArrayList<Knight>();
    ArrayList<Swordsman> Army2 = new ArrayList<Swordsman>();
    ArrayList<Pikeman> Army3 = new ArrayList<Pikeman>();*/

    public static void main(String[] arg){
        MainFrame f = new MainFrame();
    }

    Blue blue = new Blue(); //dziwne obiekty, zeby nie bylo static'ow
    Red red = new Red();

    public MainFrame(){ //konstruktor na okno aplikacji
        JFrame frame = new JFrame("Simulation");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        blue.teamSelectorBlue();
        red.teamSelectorRed();
        //wypelnianie tablic jednostkami
        /*for(int i=0; i<50; i++){
            Army1.add(new Knight());
            Army2.add(new Swordsman());
            Army3.add(new Pikeman());
        }*/

        Timer timer = new Timer(10,this);   //odswiezanie ekranu w ms
        timer.restart();

        frame.add(this);

        frame.setVisible(true);
    }

    public void paint(Graphics g){  //metoda od grafiki
        //g.fillOval(10,10,100,100);
        super.paintComponent(g);
        for(Unit u1: blue.Army1){
            blue.paintBlue(g, blue.Army1);
            if(u1.getStatus()==1){
                ((Knight) u1).shapeK(g, blue.Army1); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
            if(u1.getStatus()==2){
                ((Swordsman) u1).shapeS(g, blue.Army1); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
            if(u1.getStatus()==3){
                ((Pikeman) u1).shapeP(g, blue.Army1);
            }
        
        for(Unit u2: red.Army2){
            red.paintRed(g, red.Army2);
            if(u2.getStatus()==1){
                ((Knight) u2).shapeK(g, red.Army2); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
            if(u2.getStatus()==2){
                ((Swordsman) u2).shapeS(g, red.Army2); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
            if(u2.getStatus()==3){
                ((Pikeman) u2).shapeP(g, red.Army2);
            }
        }
        for(int i=0; i<blue.Army1.size(); i++) { //przeszukiwanie arrayow za kolizja
            for(int j=0; j<red.Army2.size(); j++){
                    Unit.collision(blue.Army1.get(i), red.Army2.get(j));
            }
        }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}