package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen2;

import java.awt.*;
import javax.swing.*;

public class Battle extends JPanel{
    Battle(){
        Font f = new Font("Serif" , Font.PLAIN , 40);

        JLabel title = new JLabel();
        title.setText("ドカバトル_VS NPC");
        title.setFont(f);
        title.setBounds(Main.WIDTH / 2 - 100, 40, 900, 100);
        add(title);
    }
}
