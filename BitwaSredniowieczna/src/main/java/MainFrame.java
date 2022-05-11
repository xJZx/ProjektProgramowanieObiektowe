import Unit.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JPanel implements ActionListener {
    //presety armii (trzeba je zapełnic jakos)
    ArrayList<Unit> Army1 = new ArrayList<Unit>();
    ArrayList<Unit> Army2 = new ArrayList<Unit>();
    ArrayList<Unit> Army3 = new ArrayList<Unit>();

    public static void main(String[] arg){
        Frame f = new Frame();
    }

    public void paint(Graphics g){  //metoda od grafiki
        //g.fillOval(10,10,100,100);
        super.paintComponent(g);
        for(Unit u: Army1){
            u.paint(g); //trzeba stworzyc metode przydzielajaca kolor unitom w klasie Team np.
        }
    }

    public MainFrame(){ //konstruktor na okno aplikacji
        JFrame frame = new JFrame("Simulation");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //wypelnianie tablic jednostkami
        for(int i=0; i<100; i++){
            Army1.add(new Unit());
            Army2.add(new Unit());
            Army3.add(new Unit());
        }

        Timer timer = new Timer(10,this);
        timer.start();

        frame.add(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}