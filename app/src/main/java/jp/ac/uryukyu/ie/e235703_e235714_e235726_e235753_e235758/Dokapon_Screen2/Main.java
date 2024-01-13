package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;

public class Main extends JFrame{
    static int WIDTH = 1470;  //画面幅
    static int HEIGHT = 940;  //画面高さ

  public static void main(String args[]) throws Exception{
    int WIDTH = Main.WIDTH;
    int HEIGHT = Main.HEIGHT;

    //画面の生成
    Main frame = new Main();
    frame.setTitle("どかどかゲーム");
    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    device.setFullScreenWindow(frame);  //フルスクリーン設定
    frame.setBounds(0, 0, WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

  Main() throws Exception{
    Test test = new Test();
    Container contentpane = getContentPane();
    contentpane.add(test);
  }
}