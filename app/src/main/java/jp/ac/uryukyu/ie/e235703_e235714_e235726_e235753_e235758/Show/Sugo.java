package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Sugo extends JPanel{
    int w; //文字数
    int member;
    int user = 1;
    int WIDTH = Main.WIDTH;
    int HEIGHT = Main.HEIGHT;
    Font fm = new Font("Serif" , Font.PLAIN , 40); //フォント設定

    //コンストラクタ（初期化処理）
    public Sugo(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setOpaque(false);
    }

    //描画処理
    public void paintComponent(Graphics g){
        //すごろく画面
        BufferedImage imgBack = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathBack = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/IMG/map.png";

        try {
            imgBack = ImageIO.read(new File(pathBack));
        } catch (Exception e) {
            e.printStackTrace();
            imgBack = null;
        }

        g2.drawImage(imgBack, 0,0,WIDTH,HEIGHT, this);
    }
}
