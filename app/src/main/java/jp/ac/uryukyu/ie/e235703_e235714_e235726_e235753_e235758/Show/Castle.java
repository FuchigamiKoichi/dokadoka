package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;


//HPと状態異常を全回復させる機能を持つクラス
public class Castle extends JPanel{
    private String[] texts = {"a","b","c","d"};
    private int currentIndex = 0;
    static FightCharacter ExPlayer = new FightCharacter("岸田", 100,5 , 10, 12, 2, 50, "健康");//仮のプレイヤー
    public Castle(FightCharacter player1){

        texts[0] = "これまでよく頑張ったね";
        texts[1] = "頑張ってるようだな" + ExPlayer.getName() + "よ。" + "まずは、キズついた体を治してあげるね！";
        texts[2] = "キズついた体はきれいに治ったよ";
        texts[3] = "これからどうする？";
        setSize(400,200);
        King kingPanel = new King(ExPlayer);
        add(kingPanel);
    }

    class King extends JPanel{
        private BackgroundMusicPlayer bgmPlayer;
        public King(FightCharacter ExPlayer){
            this.bgmPlayer = new BackgroundMusicPlayer(System.getProperty("user.dir")+"/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/BGM/duel.wav");
            
            new Thread(() -> bgmPlayer.play()).start();
            
            
            JLabel conversation = new JLabel();
            conversation.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 40));
            
            add(conversation);

            JButton choice1 = new JButton("出る");//このボタンを押したとき、マップ画面に戻る
            JButton choice2 = new JButton("転職");
            JButton choice3 = new JButton("特産品");
            choice1.setToolTipText("メニューに戻る");
            choice2.setToolTipText("転職する");
            choice3.setToolTipText("特産品を王様に届ける");

            Timer timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if(currentIndex < texts.length){
                        conversation.setText(texts[currentIndex]);
                        currentIndex++;
                        if(currentIndex == 4){
                            add(choice1);
                            add(choice2);
                            add(choice3);
                        }
                    }else{
                        ((Timer) e.getSource()).stop();
                    }
                }
            });
            timer.start();
        }
    }
}