import javax.swing.*;

import Unit.Knight;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JPanel implements ActionListener {
    //presety armii (trzeba je zapełnic jakos)
    ArrayList<Knight> Army1 = new ArrayList<Knight>();

    public static void main(String[] arg){
        MainFrame f = new MainFrame();
    }

    public void paint(Graphics g){  //metoda od grafiki
        //g.fillOval(10,10,100,100);
        super.paintComponent(g);
        for(Knight u: Army1){
            u.paint(g); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
        }
    }

    public MainFrame(){ //konstruktor na okno aplikacji
        JFrame frame = new JFrame("Simulation");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //wypelnianie tablic jednostkami
        for(int i=0; i<100; i++){
            Army1.add(new Knight());
        }

        Timer timer = new Timer(10,this);
        timer.restart();

        frame.add(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}