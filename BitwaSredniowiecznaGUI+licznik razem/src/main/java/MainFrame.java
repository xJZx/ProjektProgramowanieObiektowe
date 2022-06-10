import javax.swing.*;
import javax.swing.border.Border;
/*
co jeszcze zrobic:
- naprawić wychodzące poza prawą krawędź ekranu jednostki
- kolizje dla tego samego typu jednostek
- przyciski do wybierania presetów
- counter dla red i blue osobno
- kamien
 */
import PackageUnit.Knight;
import PackageUnit.Pikeman;
import PackageUnit.Swordsman;
import PackageUnit.Unit;
import PackageUnit.PackageTeam.Blue;
import PackageUnit.PackageTeam.Red;
import PackageUnit.PackageTeam.Team;
import com.sun.tools.javac.Main;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JPanel implements ActionListener {
    public static void main(String[] arg) {
        MainFrame f = new MainFrame();
    }
    int count=0;
    Blue blue = new Blue(); //dziwne obiekty, zeby nie bylo static'ow
    Red red = new Red();
    Unit unit = new Unit();

    public MainFrame() { //konstruktor na okno aplikacji
        blue.teamSelectorBlue();    //metoda wybierajaca preset armii
        red.teamSelectorRed();

        JComponent simPanel = new JComponent() {
            public void paintComponent(Graphics g) {  //metoda od grafiki
                super.paintComponent(g);
                for (Unit u1 : blue.Army1) {
                    blue.paintBlue(g, blue.Army1);  //metoda przydzielajaca kolor unitom
                    if (u1.getStatus() == 1) {
                        ((Knight) u1).shapeK(g, blue.Army1);
                    }
                    if (u1.getStatus() == 2) {
                        ((Swordsman) u1).shapeS(g, blue.Army1);
                    }
                    if (u1.getStatus() == 3) {
                        ((Pikeman) u1).shapeP(g, blue.Army1);
                    }
                }
                for (Unit u2 : red.Army2) {
                    red.paintRed(g, red.Army2); //metoda przydzielajaca kolor unitom
                    if (u2.getStatus() == 1) {
                        ((Knight) u2).shapeK(g, red.Army2);
                    }
                    if (u2.getStatus() == 2) {
                        ((Swordsman) u2).shapeS(g, red.Army2);
                    }
                    if (u2.getStatus() == 3) {
                        ((Pikeman) u2).shapeP(g, red.Army2);
                    }
                }

                for (int i = 0; i < blue.Army1.size(); i++) { //przeszukiwanie arrayow za kolizja
                    for (int j = 0; j < red.Army2.size(); j++) {
                        unit.collision(blue.Army1.get(i), red.Army2.get(j), blue.Army1, red.Army2);
                    }
                }

                for (int i = 0; i < red.Army2.size(); i++) { //przeszukiwanie arrayow za kolizja
                    for (int j = 0; j < blue.Army1.size(); j++) {
                        unit.collision(red.Army2.get(i), blue.Army1.get(j), red.Army2, blue.Army1);
                    }
                }
            }
        }; //panel od symulacji

        simPanel.setBounds(0, 0, 800, 600);
        simPanel.setLayout(new BorderLayout()); //musi byc bo inaczej nic sie nie pojawia

        JPanel panelBlue = new JPanel(); //panel od licznika śmierci
        panelBlue.setBounds(0, 600, 400, 50);
        panelBlue.setBackground(Color.BLUE);

        JLabel labelBlue = new JLabel(); //tekst licznika śmierci
        labelBlue.setText("Killed units: " + unit.getKillCounter());
        labelBlue.setHorizontalTextPosition(JLabel.CENTER);
        panelBlue.add(labelBlue);

        JPanel panelRed = new JPanel(); //panel od licznika śmierci
        panelRed.setBounds(400, 600, 400, 50);
        panelRed.setBackground(Color.RED);

        JLabel labelRed = new JLabel(); //tekst licznika śmierci
        labelRed.setText("Killed units: " + unit.getKillCounter());
        labelRed.setHorizontalTextPosition(JLabel.CENTER);
        panelRed.add(labelRed);

        JFrame frame = new JFrame("Simulation"); //ramka
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simPanel.repaint();
                panelBlue.repaint();
                panelRed.repaint();
                labelRed.setText("Killed units: " + unit.getKillCounter());
                labelBlue.setText("Killed units: " + unit.getKillCounter());
                }
            });   //odswiezanie ekranu w ms
        timer.restart();

        frame.add(panelBlue);
        frame.add(panelRed);
        frame.add(simPanel);

        frame.setVisible(true);
//        counter.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent e){

    }

}