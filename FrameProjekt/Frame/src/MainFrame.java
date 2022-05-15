import javax.swing.*;

import Unit.Knight;
import Unit.Swordsman;

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

    public void paint(Graphics g){  //metoda od grafiki
        //g.fillOval(10,10,100,100);
        super.paintComponent(g);
        for(Knight u: Army1){
            u.paintK(g, Army1); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
        }
        for(Swordsman u: Army2){
            u.paintS(g, Army2); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
        }
        for(int i=0; i<Army1.size(); i++) { //przeszukiwanie arrayow za kolizja
            for(int j=i+1; j<Army2.size(); j++){
                Army1.get(i).collision(Army1.get(i), Army2.get(j));
            }
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}