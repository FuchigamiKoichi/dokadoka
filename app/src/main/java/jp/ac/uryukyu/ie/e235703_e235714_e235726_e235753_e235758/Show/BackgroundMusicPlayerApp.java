package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundMusicPlayerApp {
    private BackgroundMusicPlayer bgmPlayer;

    public BackgroundMusicPlayerApp(String filePath) {
        this.bgmPlayer = new BackgroundMusicPlayer(filePath);
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("Background Music Player");
        JButton playButton = new JButton("Play");

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 別スレッドで音声再生
                new Thread(() -> bgmPlayer.play()).start();
            }
        });

        frame.getContentPane().add(playButton);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}