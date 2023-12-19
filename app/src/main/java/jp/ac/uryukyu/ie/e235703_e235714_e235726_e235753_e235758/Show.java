package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
// import javax.swing.plaf.metal.MetalBorders.RolloverButtonBorder;

// import java.util.Map;
// import java.util.HashMap;
// import java.util.Scanner;
// import java.util.Random;

// import main.java.jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;
// import main.java.jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_sugoroku.*;;

//import com.google.common.base.Joiner;

public class Show extends JPanel{
    //Game game = new Game();
    int member = 1; //プレイヤー数
    int w; //文字数
    int mode = 0;  //０：タイトル　１：人数設定
    int character = 1; //登録中のプレイヤー番号
    static final int WIDTH = 1200; // 画面サイズ（幅）
    static final int HEIGHT = 800; // 画面サイズ（高さ）
    int lm = 50;    // 左側余白
    int tm = 100;   // 上側余白
    Font fm = new Font("Serif" , Font.PLAIN , 40); //フォント設定

    //コンストラクタ（初期化処理）
    public Show(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addMouseListener(new MouseProc());
    }

    //描画処理
    public void paintComponent(Graphics g){
        if(mode == 0){
            //タイトル画面
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(Color.green);
            g.setFont(fm);
            w = g.getFontMetrics().stringWidth("DOKADOKA GAME");
            g.drawString("DOKADOKA GAME", WIDTH/2 - w/2, 200);

            g.setColor(Color.blue);
            g.setFont(fm);
            w = g.getFontMetrics().stringWidth("クリックすると始まります");
            g.drawString("クリックすると始まります", WIDTH/2 - w/2, HEIGHT-200);

        }else if(mode == 1){
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
            up.setBounds(WIDTH/2 - 50, 200, 100, 70);  //ボタンの書式設定
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
            down.setBounds(WIDTH/2 - 50, 500, 100, 70);  //ボタンの書式設定
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

            //スタートボタンの作成
            JButton start = new JButton("スタート！！");
            start.setFont(fm);
            start.setBounds(WIDTH-300, HEIGHT-100, 250, 70);
            ActionListener startaction = new  ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    mode = 2;
                    repaint();  //再描画
                }
            };
            start.addActionListener(startaction);

            add(start);
            
        }else if (mode == 2 ){
            //キャラクター名入力画面
            removeAll();  //まっさらな画面

            g.setColor(Color.black);
            g.fillRect(0,0,WIDTH,HEIGHT);

            g.setColor(Color.yellow);
            g.setFont(fm);
            w = g.getFontMetrics().stringWidth("プレイヤー"+ character + "の名前教えて！！");
            g.drawString("プレイヤー"+ character +"の名前を教えて！！", WIDTH/2 - w/2, 200);

            //キャラクター名入力欄
            JTextField text = new JTextField("キャラクター名");
            text.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 30));
            text.setBounds(WIDTH/2 - w/4, 300, 320, 80);
            add(text);

            //登録ボタン
            JButton regist = new JButton("登録！！");
            regist.setFont(fm);
            regist.setBounds(WIDTH-300, HEIGHT-100, 250, 70);
            
            ActionListener registaction = new  ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //character += 1;
                    System.out.println("成功");
                    repaint();  //再描画
                }
            };
            regist.addActionListener(registaction);

            add(regist);
        }
    };

    class MouseProc extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            if(mode == 0){
                mode = 1;
            }

            repaint();
        }
    }
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().add(new Show());
        f.pack();
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
