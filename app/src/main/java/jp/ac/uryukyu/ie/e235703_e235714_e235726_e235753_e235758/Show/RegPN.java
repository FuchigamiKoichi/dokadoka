package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RegPN extends JPanel{
    private int w; //文字数
    private int member = Main.member;
    private int WIDTH = Main.WIDTH;
    private int HEIGHT = Main.HEIGHT;
    private Font fm = new Font("Serif" , Font.PLAIN , 40); //フォント設定

    //コンストラクタ（初期化処理）
    public RegPN(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public int getMember() {
        return member;
    }

    //描画処理
    public void paintComponent(Graphics g){
        //人数設定画面
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.blue);
        g.setFont(fm);
        w = g.getFontMetrics().stringWidth("何人で遊ぶのか教えて");
        g.drawString("何人で遊ぶのか教えて", WIDTH/2 - w/2, 100);

        g.setColor(Color.yellow);
        g.setFont(fm);
        w = g.getFontMetrics().stringWidth(member+"人で遊ぶの？");
        g.drawString(member+"人で遊ぶの？", WIDTH/2 - w/2, 400);

        //人数をプラスにするボタンの作成
        JButton up = new JButton("+１"); //ボタンの作成
        up.setFont(fm);  //ボタンの文字（＋１）のフォント設定
        up.setBounds(WIDTH/2 - 200, 500, 100, 70);  //ボタンの書式設定
        ActionListener upaction = new  ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                member += 1;  //ボタンが押された時の処理
                repaint();  //再描画
            }
        };
        up.addActionListener(upaction);

        add(up);  //ボタンの設置

        //人数をマイナスにするボタンの作成
        JButton down = new JButton("-１"); //ボタンの作成
        down.setFont(fm);   //ボタンの文字（−１）のフォント設定
        down.setBounds(WIDTH/2 + 100, 500, 100, 70);  //ボタンの書式設定
        ActionListener downaction = new  ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(member - 1 > 0 ){
                    member -= 1;  //ボタンが押された時の処理
                }else{
                }
                repaint();  //再描画
            }
        };
        down.addActionListener(downaction);

        add(down);
    }
}