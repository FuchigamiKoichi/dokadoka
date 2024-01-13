package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BackGround extends JPanel{
    int w; //文字数
    int member;
    int user = 1;
    int WIDTH = Main.WIDTH;
    int HEIGHT = Main.HEIGHT;
    Font fm = new Font("Serif" , Font.PLAIN , 40); //フォント設定

    //コンストラクタ（初期化処理）
    public BackGround(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setOpaque(false);
    }

    //描画処理
    public void paintComponent(Graphics g){
        BufferedImage imgBack = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathBack = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/Dokapon_Screen2/IMG/433170.png";
        try {
            imgBack = ImageIO.read(new File(pathBack));
        } catch (Exception e) {
            e.printStackTrace();
            imgBack = null;
        }

        g2.drawImage(imgBack, 0,0,WIDTH,HEIGHT, this);

        JButton move = new JButton("ボタン");
        move.setBounds(Main.WIDTH - 200, Main.HEIGHT - 200, 200, 200);
        add(move);

        ActionListener moveAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();

                Battle bt = new Battle();
                bt.setBounds(0,0,WIDTH,HEIGHT);
                add(bt);

                repaint();
            }
        };
        move.addActionListener(moveAction);
    }
}