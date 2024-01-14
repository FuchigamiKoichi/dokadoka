package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SugorokuGame extends JFrame {
    private ItemShop itemShop;

    public SugorokuGame() {
        setTitle("すごろくゲーム - アイテムショップ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1470, 940);
        setLocationRelativeTo(null);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SugorokuGame().setVisible(true);
            }
        });
    }
}
