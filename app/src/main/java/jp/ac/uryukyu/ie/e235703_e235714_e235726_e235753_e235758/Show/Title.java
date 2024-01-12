package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import java.awt.*;
import javax.swing.*;

class Title extends JPanel{
    int w; //文字数
    int WIDTH = Main.WIDTH;
    int HEIGHT = Main.HEIGHT;
    Font fm = new Font("Serif" , Font.PLAIN , 40); //フォント設定

    //コンストラクタ（初期化処理）
    public Title(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    //描画処理
    public void paintComponent(Graphics g){
        //タイトル画面
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.green);
        g.setFont(fm);
        w = g.getFontMetrics().stringWidth("DOKADOKA GAME");
        g.drawString("DOKADOKA GAME", WIDTH/2 - w/2, 200);
    }
}