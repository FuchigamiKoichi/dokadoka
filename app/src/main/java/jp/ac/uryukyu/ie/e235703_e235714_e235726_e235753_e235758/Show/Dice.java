package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

class Dice1 extends JPanel{
    public Dice1(){
        setPreferredSize(new Dimension(200, 200));
    }

    public void paintComponent(Graphics g){
        BufferedImage imgDice1 = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathDice1 = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/IMG/dice1.png";

        try {
            imgDice1 = ImageIO.read(new File(pathDice1));
        } catch (Exception e) {
            e.printStackTrace();
            imgDice1 = null;
        }
        g2.drawImage(imgDice1, 0,0, 100,100, this);
    }
}

class Dice2 extends JPanel{
    public Dice2(){
        setPreferredSize(new Dimension(200, 200));
    }

    public void paintComponent(Graphics g){
        BufferedImage imgDice2 = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathDice2 = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/IMG/dice2.png";

        try {
            imgDice2 = ImageIO.read(new File(pathDice2));
        } catch (Exception e) {
            e.printStackTrace();
            imgDice2 = null;
        }
        g2.drawImage(imgDice2, 0,0, 100,100, this);
    }
}

class Dice3 extends JPanel{
    public Dice3(){
        setPreferredSize(new Dimension(200, 200));
    }

    public void paintComponent(Graphics g){
        BufferedImage imgDice3 = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathDice3 = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/IMG/dice3.png";

        try {
            imgDice3 = ImageIO.read(new File(pathDice3));
        } catch (Exception e) {
            e.printStackTrace();
            imgDice3 = null;
        }
        g2.drawImage(imgDice3, 0,0, 100,100, this);
    }
}

class Dice4 extends JPanel{
    public Dice4(){
        setPreferredSize(new Dimension(200, 200));
    }

    public void paintComponent(Graphics g){
        BufferedImage imgDice4 = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathDice4 = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/IMG/dice4.png";

        try {
            imgDice4 = ImageIO.read(new File(pathDice4));
        } catch (Exception e) {
            e.printStackTrace();
            imgDice4 = null;
        }
        g2.drawImage(imgDice4, 0,0, 100,100, this);
    }
}

class Dice5 extends JPanel{
    public Dice5(){
        setPreferredSize(new Dimension(200, 200));
    }

    public void paintComponent(Graphics g){
        BufferedImage imgDice5 = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathDice5 = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/IMG/dice5.png";

        try {
            imgDice5 = ImageIO.read(new File(pathDice5));
        } catch (Exception e) {
            e.printStackTrace();
            imgDice5 = null;
        }
        g2.drawImage(imgDice5, 0,0, 100,100, this);
    }
}

class Dice6 extends JPanel{
    public Dice6(){
        setPreferredSize(new Dimension(200, 200));
    }

    public void paintComponent(Graphics g){
        BufferedImage imgDice6 = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathDice6 = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/IMG/dice6.png";

        try {
            imgDice6 = ImageIO.read(new File(pathDice6));
        } catch (Exception e) {
            e.printStackTrace();
            imgDice6 = null;
        }
        g2.drawImage(imgDice6, 0,0, 100,100, this);
    }
}

class TurnShow extends JPanel{
    public TurnShow(){
        setPreferredSize(new Dimension(400, 200));
        setLayout(null);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 400, 200);
    }
}