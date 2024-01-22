package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RankingShow extends JFrame{
    private RankingManager rankingManager;
    public RankingShow(){
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RankingShow().setVisible(true));
    }
}
