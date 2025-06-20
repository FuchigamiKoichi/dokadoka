package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
// import java.io.File;
import javax.imageio.ImageIO;

public class Sugo extends JPanel{
    private int WIDTH = Main.WIDTH;
    private int HEIGHT = Main.HEIGHT;

    //コンストラクタ（初期化処理）
    public Sugo(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setOpaque(false);
        setLayout(null);
    }

    //描画処理
    public void paintComponent(Graphics g){
        //すごろく画面
        BufferedImage imgBack = null;
        Graphics2D g2 = (Graphics2D) g;

        try {
            imgBack = ImageIO.read(getClass().getClassLoader().getResourceAsStream("IMG/map.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgBack = null;
        }

        g2.drawImage(imgBack, 0,0,WIDTH,HEIGHT, this);
    }
}