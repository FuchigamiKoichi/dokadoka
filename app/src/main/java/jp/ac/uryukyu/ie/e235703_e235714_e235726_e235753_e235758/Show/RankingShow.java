package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RankingShow extends JPanel{
    private RankingManager rankingManager;
    public RankingShow(){
        JButton showRankButton = new JButton("ランキングを表示");
        showRankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                showRanking();
            }
        });
        add(showRankButton);

        rankingManager = new RankingManager();
    }

    public void showRanking(){
        String ranking = rankingManager.getRanking();//ランキングを取得するメソッド
        JOptionPane.showMessageDialog(this,"プレイヤーランキング:\n" + ranking);
    }
}
