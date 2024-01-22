package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SugorokuGame extends JPanel {
    private ItemShop itemShop;

    public SugorokuGame() {
        initializeUI();
    }

    private void initializeUI() {
        itemShop = new ItemShop();

        JButton challengeButton = new JButton("店主に挑む");
        challengeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemShop.challengeShopkeeper();
            }
        });

        JButton exitButton = new JButton("イベント終了");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemShop.exitEvent();
            }
        });

        setLayout(new BorderLayout());
        add(itemShop, BorderLayout.CENTER);
        add(challengeButton, BorderLayout.WEST);
        add(exitButton, BorderLayout.EAST);
    }
}