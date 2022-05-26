import javax.swing.*;

import Unit.Unit;
import Unit.Knight;
import Unit.Swordsman;
import Unit.Pikeman;
import Team.Team;

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

    public MainFrame(){ //konstruktor na okno aplikacji
        JFrame frame = new JFrame("Simulation");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Team.teamSelectorBlue();
        Team.teamSelectorRed();
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
        for(Unit u1: Team.Army1){
            if(u1.getStatus()==1){
                ((Knight) u1).paintK(g, Team.Army1); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
            if(u1.getStatus()==2){
                ((Swordsman) u1).paintS(g, Team.Army1); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
            if(u1.getStatus()==3){
                ((Pikeman) u1).paintP(g, Team.Army1);
            }
        
        for(Unit u2: Team.Army2){
            if(u2.getStatus()==1){
                ((Knight) u2).paintK(g, Team.Army2); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
            if(u2.getStatus()==2){
                ((Swordsman) u2).paintS(g, Team.Army2); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
            if(u2.getStatus()==3){
                ((Pikeman) u2).paintP(g, Team.Army2);
            }
        }
        for(int i=0; i<Team.Army1.size(); i++) { //przeszukiwanie arrayow za kolizja
            for(int j=0; j<Team.Army2.size(); j++){
                    Unit.collision(Team.Army1.get(i), Team.Army2.get(j));
            }
        }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}