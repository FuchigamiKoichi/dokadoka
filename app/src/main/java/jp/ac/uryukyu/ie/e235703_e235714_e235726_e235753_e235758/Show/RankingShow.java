package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;

public class RankingShow extends JPanel{
    private RankingManager rankingManager;
    public RankingShow(ArrayList<User> Users){
        setLayout(null);
        JButton showRankButton = new JButton("ランキングを表示");
        showRankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                showRanking(Users);
            }
        });
        showRankButton.setBounds(100,100,400,400);
        add(showRankButton);

        rankingManager = new RankingManager();
    }

    public void showRanking(ArrayList<User> Users){
        String ranking = rankingManager.getRanking(Users);//ランキングを取得するメソッド
        JOptionPane.showMessageDialog(this,"プレイヤーランキング:\n" + ranking);
    }
}
