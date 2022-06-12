import javax.swing.*;
/*
co jeszcze zrobic:
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
import java.io.*;

public class MainFrame extends JPanel implements ActionListener {
    public static void main(String[] arg) {
        MainFrame f = new MainFrame();
    }

    private final Blue blue = new Blue(); //dziwne obiekty, zeby nie bylo static'ow
    private final Red red = new Red();
    private final Unit unit = new Unit();
    private int count=0;

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

    JPanel panelTimer = new JPanel(); //panel od licznika śmierci
    JLabel labelTimer = new JLabel(); //tekst licznika śmierci
    JPanel panelKill = new JPanel(); //panel od licznika śmierci
    JLabel labelKill = new JLabel(); //tekst licznika śmierci

    private Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            simPanel.repaint();
            panelTimer.repaint();
            panelKill.repaint();
            labelKill.setText("Killed units: " + unit.getKillCounter());
            labelTimer.setText("Elapsed time: " + count/50);
        }
    });   //odswiezanie ekranu w ms

    JDialog dialog1 = new JDialog();
    JDialog dialog2 = new JDialog();

    private MainFrame() { //konstruktor na okno aplikacji
        selectPresetRed();
        selectPresetBlue();

            simPanel.setBounds(0, 0, 800, 600);
            simPanel.setLayout(new BorderLayout()); //musi byc bo inaczej nic sie nie pojawia

            panelTimer.setBounds(0, 600, 400, 50);
            panelTimer.setBackground(Color.GRAY);

            labelTimer.setText("Time elapsed: " + count);
            labelTimer.setHorizontalTextPosition(JLabel.CENTER);
            panelTimer.add(labelTimer);

            panelKill.setBounds(400, 600, 400, 50);
            panelKill.setBackground(Color.RED);

            labelKill.setText("Killed units: " + unit.getKillCounter());
            labelKill.setHorizontalTextPosition(JLabel.CENTER);
            panelKill.add(labelKill);

            JFrame frame = new JFrame("Simulation"); //ramka
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(815, 665);
            frame.setLocationRelativeTo(null);

            frame.add(panelTimer);
            frame.add(panelKill);
            frame.add(simPanel);

            frame.setVisible(true);
            dialog1.setVisible(true);
            dialog2.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getActionCommand().equals("OK!")){ //klikniecie OK powoduje wyjscie z aplikacji
            System.exit(0);
        }

        if(e.getActionCommand().equals("Preset 1 (more Knights)")){ //klikniecie OK powoduje wyjscie z aplikacji
            blue.teamSelectorBlue(1);
            dialog1.dispose();
            timer.start();
        }

        if(e.getActionCommand().equals("Preset 2 (more Swordsmen)")){ //klikniecie OK powoduje wyjscie z aplikacji
            blue.teamSelectorBlue(2);
            dialog1.dispose();
            timer.start();
        }

        if(e.getActionCommand().equals("Preset 3 (more Pikemen)")){ //klikniecie OK powoduje wyjscie z aplikacji
            blue.teamSelectorBlue(3);
            dialog1.dispose();
            timer.start();
        }

        if(e.getActionCommand().equals("Preset 1 (more Knights) ")){ //klikniecie OK powoduje wyjscie z aplikacji
            red.teamSelectorRed(1);
            dialog2.dispose();
        }

        if(e.getActionCommand().equals("Preset 2 (more Swordsmen) ")){ //klikniecie OK powoduje wyjscie z aplikacji
            red.teamSelectorRed(2);
            dialog2.dispose();
        }

        if(e.getActionCommand().equals("Preset 3 (more Pikemen) ")){ //klikniecie OK powoduje wyjscie z aplikacji
            red.teamSelectorRed(3);
            dialog2.dispose();
        }
    }

    //czy koniec gry!!!!!!!!!!!!!!!
    private void check(){ //metoda sprawdzająca czy już koniec gry
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
            printResultsToFile();
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
            printResultsToFile();
        }
    }

    //presety!!!!!!!!!!!!
    private void selectPresetBlue(){
        dialog1.setSize(400,250);
        dialog1.setLayout(null);
        dialog1.setLocationRelativeTo(null);

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

    private void selectPresetRed(){

        dialog2.setSize(400,250);
        dialog2.setLayout(null);
        dialog2.setLocationRelativeTo(null);

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

    private void printResultsToFile(){
        try{
            FileWriter fileWriter = new FileWriter("results.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("Time of simulation: " + count/50 + "\n Killed units: " + unit.getKillCounter());
            printWriter.flush();
        }

        catch(Exception E){
            JOptionPane.showMessageDialog(null, "Record not saved");
        }
    }
}