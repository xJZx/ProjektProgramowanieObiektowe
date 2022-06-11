import javax.swing.*;
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

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JPanel implements ActionListener {
    public static void main(String[] arg) {
        MainFrame f = new MainFrame();
    }

    Blue blue = new Blue(); //dziwne obiekty, zeby nie bylo static'ow
    Red red = new Red();
    Unit unit = new Unit();

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
                    check();
                }
            }

            for (int i = 0; i < red.Army2.size(); i++) { //przeszukiwanie arrayow za kolizja
                for (int j = 0; j < blue.Army1.size(); j++) {
                    unit.collision(red.Army2.get(i), blue.Army1.get(j), red.Army2, blue.Army1);
                    check();
                }
            }
        }
    }; //panel od symulacji

    JPanel panelTime = new JPanel(); //panel od licznika śmierci
    JLabel labelTime = new JLabel(); //tekst licznika śmierci
    JPanel panelKill = new JPanel(); //panel od licznika śmierci
    JLabel labelKill = new JLabel(); //tekst licznika śmierci

    Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            simPanel.repaint();
            panelTime.repaint();
            panelKill.repaint();
            labelKill.setText("Killed units: " + unit.getKillCounter());
            labelTime.setText("Elapsed time: " + elapsedTime);
        }
    });   //odswiezanie ekranu w ms

    boolean presetRed = false;
    boolean presetBlue = false;
    long startTime = System.currentTimeMillis();
    long elapsedTime = System.currentTimeMillis() - startTime;

    public MainFrame() { //konstruktor na okno aplikacji
        selectPresetRed();
        selectPresetBlue();

        simPanel.setBounds(0, 0, 800, 600);
        simPanel.setLayout(new BorderLayout()); //musi byc bo inaczej nic sie nie pojawia

        panelTime.setBounds(0, 600, 400, 50);
        panelTime.setBackground(Color.GRAY);

        labelTime.setText("Elapsed time: " + elapsedTime);
        labelTime.setHorizontalTextPosition(JLabel.CENTER);
        panelTime.add(labelTime);

        panelKill.setBounds(400, 600, 400, 50);
        panelKill.setBackground(Color.RED);

        labelKill.setText("Killed units: " + unit.getKillCounter());
        labelKill.setHorizontalTextPosition(JLabel.CENTER);
        panelKill.add(labelKill);

        JFrame frame = new JFrame("Simulation"); //ramka
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(815, 665);
        frame.setLocationRelativeTo(null);

        frame.add(panelTime);
        frame.add(panelKill);
        frame.add(simPanel);

        timer.start();

        frame.setVisible(true);
        dialog1.setVisible(true);
        dialog2.setVisible(true);
//      counter.setVisible(true);
    }

    JDialog dialog1 = new JDialog();
    JDialog dialog2 = new JDialog();

    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getActionCommand().equals("OK!")){ //klikniecie OK powoduje wyjscie z aplikacji
            System.exit(0);
        }

        else if(e.getActionCommand().equals("Preset 1 (more Knights)")){ //klikniecie OK powoduje wyjscie z aplikacji
            blue.teamSelectorBlue(1);
            presetBlue=true;
            dialog1.dispose();
        }

        else if(e.getActionCommand().equals("Preset 2 (more Swordsmen)")){ //klikniecie OK powoduje wyjscie z aplikacji
            blue.teamSelectorBlue(2);
            presetBlue=true;
            dialog1.dispose();
        }

        else if(e.getActionCommand().equals("Preset 3 (more Pikemen)")){ //klikniecie OK powoduje wyjscie z aplikacji
            blue.teamSelectorBlue(3);
            presetBlue=true;
            dialog1.dispose();
        }

        else if(e.getActionCommand().equals("Preset 1 (more Knights) ")){ //klikniecie OK powoduje wyjscie z aplikacji
            red.teamSelectorRed(1);
            presetRed=true;
            dialog2.dispose();
        }

        else if(e.getActionCommand().equals("Preset 2 (more Swordsmen) ")){ //klikniecie OK powoduje wyjscie z aplikacji
            red.teamSelectorRed(2);
            presetRed=true;
            dialog2.dispose();
        }

        else if(e.getActionCommand().equals("Preset 3 (more Pikemen) ")){ //klikniecie OK powoduje wyjscie z aplikacji
            red.teamSelectorRed(3);
            presetRed=true;
            dialog2.dispose();
        }
    }

    //czy koniec gry!!!!!!!!!!!!!!!
    public void check(){ //metoda sprawdzająca czy już koniec gry
        if(blue.Army1.size()==0){
            timer.stop();
            JDialog dialog = new JDialog(); //okno dialogowe
            dialog.setSize(200,150);
            dialog.setLayout(null);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            JLabel label = new JLabel("Red wins!"); //napis koncowy
            label.setBounds(70,30,100,10);
            dialog.add(label);

            JPanel panel=new JPanel(); //panel z przyciskiem
            dialog.add(panel);

            JButton button = new JButton("OK!"); //przycisk
            button.addActionListener(this);
            button.setBounds(70,50,60,25);
            panel.add(button);

            dialog.add(button);
        }

        else if(red.Army2.size()==0){
            timer.stop();
            JDialog dialog = new JDialog(); //okno dialogowe
            dialog.setSize(200,150);
            dialog.setLayout(null);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            JLabel label = new JLabel("Blue wins!"); //napis koncowy
            label.setBounds(70,30,100,10);
            dialog.add(label);

            JPanel panel=new JPanel(); //panel z przyciskiem
            dialog.add(panel);

            JButton button = new JButton("OK!"); //przycisk
            button.addActionListener(this);
            button.setBounds(70,50,60,25);
            panel.add(button);

            dialog.add(button);
        }
    }

    //presety!!!!!!!!!!!!
    public void selectPresetBlue(){
        dialog1.setSize(400,250);
        dialog1.setLayout(null);
        dialog1.setLocationRelativeTo(null);
//        dialog1.setVisible(true);
//        dialog1.setAlwaysOnTop(true);

        JLabel label = new JLabel("Select the preset for Team Blue:"); //napis koncowy
        label.setBounds(100,30,200,20);
        dialog1.add(label);

        JPanel panel=new JPanel(); //panel z przyciskiem
        dialog1.add(panel);

        JButton b1 = new JButton("Preset 1 (more Knights)");
        b1.setBounds(95,80,200,25);
        b1.addActionListener(this);
        panel.add(b1);

        JButton b2 = new JButton("Preset 2 (more Swordsmen)");
        b2.setBounds(95,110,200,25);
        b2.addActionListener(this);
        panel.add(b2);

        JButton b3 = new JButton("Preset 3 (more Pikemen)");
        b3.setBounds(95,140,200,25);
        b3.addActionListener(this);
        panel.add(b3);

        dialog1.add(b1);
        dialog1.add(b2);
        dialog1.add(b3);
    }

    public void selectPresetRed(){

        dialog2.setSize(400,250);
        dialog2.setLayout(null);
        dialog2.setLocationRelativeTo(null);
//        dialog2.setVisible(true);
//        dialog2.setAlwaysOnTop(true);

        JLabel label = new JLabel("Select the preset for Team Red:"); //napis koncowy
        label.setBounds(100,30,200,20);
        dialog2.add(label);

        JPanel panel=new JPanel(); //panel z przyciskiem
        dialog2.add(panel);

        JButton b1 = new JButton("Preset 1 (more Knights) ");
        b1.setBounds(95,80,200,25);
        b1.addActionListener(this);
        panel.add(b1);

        JButton b2 = new JButton("Preset 2 (more Swordsmen) ");
        b2.setBounds(95,110,200,25);
        b2.addActionListener(this);
        panel.add(b2);

        JButton b3 = new JButton("Preset 3 (more Pikemen) ");
        b3.setBounds(95,140,200,25);
        b3.addActionListener(this);
        panel.add(b3);

        dialog2.add(b1);
        dialog2.add(b2);
        dialog2.add(b3);
    }
}