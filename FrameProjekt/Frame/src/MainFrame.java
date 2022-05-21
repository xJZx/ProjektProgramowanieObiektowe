import javax.swing.*;

import Unit.Unit;
import Unit.Knight;
import Unit.Swordsman;
import Unit.Pikeman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JPanel implements ActionListener {
    //presety armii (trzeba je zapełnic jakos)
    ArrayList<Knight> Army1 = new ArrayList<Knight>();
    ArrayList<Swordsman> Army2 = new ArrayList<Swordsman>();
    ArrayList<Pikeman> Army3 = new ArrayList<Pikeman>();

    public static void main(String[] arg){
        MainFrame f = new MainFrame();
    }

    public MainFrame(){ //konstruktor na okno aplikacji
        JFrame frame = new JFrame("Simulation");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //wypelnianie tablic jednostkami
        for(int i=0; i<50; i++){
            Army1.add(new Knight());
            Army2.add(new Swordsman());
            Army3.add(new Pikeman());
        }

        Timer timer = new Timer(10,this);   //odswiezanie ekranu w ms
        timer.restart();

        frame.add(this);

        frame.setVisible(true);
    }

    public void paint(Graphics g){  //metoda od grafiki
        //g.fillOval(10,10,100,100);
        super.paintComponent(g);
        for(Knight u1: Army1){
            if(u1.getStatus()==1){
            u1.paintK(g, Army1); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
        }
        for(Swordsman u2: Army2){
            if(u2.getStatus()==2){
            u2.paintS(g, Army2); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
            }
        }
        for(Pikeman u3: Army3){
            if(u3.getStatus()==3){
                u3.paintP(g, Army3);
            }
        }
        for(int i=0; i<Army1.size(); i++) { //przeszukiwanie arrayow za kolizja
            for(int j=0; j<Army2.size(); j++){
                for(int k=0; k<Army3.size(); k++){
                    Unit.collision(Army1.get(i), Army2.get(j), Army3.get(k));
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}