package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JPanel{
    Test(){
        BackGround bg = new BackGround();
        bg.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
        add(bg);
    }
}
