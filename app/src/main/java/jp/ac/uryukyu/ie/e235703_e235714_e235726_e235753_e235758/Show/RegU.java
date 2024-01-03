package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import javax.swing.*;
import java.awt.*;

public class RegU extends JPanel{
    int w; //文字数
    int member = Main.member;
    int user = 1;
    int WIDTH = Main.WIDTH;
    int HEIGHT = Main.HEIGHT;
    Font fm = new Font("Serif" , Font.PLAIN , 40); //フォント設定

    //コンストラクタ（初期化処理）
    public RegU(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    //描画処理
    public void paintComponent(Graphics g){
        //キャラクター登録画面
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }
}