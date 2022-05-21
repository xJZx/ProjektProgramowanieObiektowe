import javax.swing.*;

import Unit.Unit;
import Unit.Knight;
import Unit.Swordsman;

import java.awt.Rectangle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JPanel implements ActionListener {
    //presety armii (trzeba je zapełnic jakos)
    ArrayList<Knight> Army1 = new ArrayList<Knight>();
    ArrayList<Swordsman> Army2 = new ArrayList<Swordsman>();

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
        for(int i=0; i<Army1.size(); i++) { //przeszukiwanie arrayow za kolizja
            for(int j=0; j<Army2.size(); j++){
                Unit.collision(Army1.get(i), Army2.get(j));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}