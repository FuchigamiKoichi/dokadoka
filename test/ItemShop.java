package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ItemShop extends JPanel {
    private DefaultListModel<Item> itemListModel;
    private JList<Item> itemList;
    private JButton purchaseButton;

    public ItemShop() {
        initializeUI();
    }

    private void initializeUI() {
        // アイテムリストのモデルを作成し、いくつかのアイテムを追加
        itemListModel = new DefaultListModel<>();
        itemListModel.addElement(new Item("悪口 ５０ダメージ", 1000, 50));
        itemListModel.addElement(new Item("イタズラ ３０ダメージ", 500, 30));
        itemListModel.addElement(new Item("弄り １０ダメージ", 100, 10));

        // JListを作成し、スクロール可能にする
        itemList = new JList<>(itemListModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(itemList);

        // アイテム購入ボタンを作成し、リスナーを追加
        purchaseButton = new JButton("アイテムを購入する");
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyItem();
            }
        });

        // UIを配置する
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(purchaseButton, BorderLayout.SOUTH);
    }

    private void buyItem() {
        // 選択されたアイテムを取得し、購入処理を行う
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
            Item selectedItem = itemListModel.getElementAt(selectedIndex);
            // ここでアイテムの価格を取得し、ポイントを減らすなどの処理を追加することができます
            JOptionPane.showMessageDialog(this, selectedItem.getName() + " を購入しました！\n" +
                    "ステータス: " + selectedItem.getdamage());
        } else {
            JOptionPane.showMessageDialog(this, "アイテムを選択してください。");
        }
    }

    // アイテムのデータを表す内部クラス
    private static class Item {
        private String name;
        private int price;
        private int damage;

        public Item(String name, int price, int damage) {
            this.name = name;
            this.price = price;
            this.damage = damage;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public int getdamage() {
            return damage;
        }

        @Override
        public String toString() {
            return name + " - " + price + "円";
        }

    }

    // じゃんけんゲームと関連するメソッド
    public void challengeShopkeeper() {
        boolean rematch = false;

        do {
            int playerChoice = showJankenDialog();
            if (playerChoice != -1) {
                int shopkeeperChoice = generateShopkeeperChoice();
                rematch = determineWinner(playerChoice, shopkeeperChoice);
            } else {
                break;
            }
        } while (rematch);
    }

    private int showJankenDialog() {
        Object[] options = {"グー", "チョキ", "パー"};
        int playerChoice = JOptionPane.showOptionDialog(this,
                "じゃんけん！",
                "店主とのじゃんけん",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        return playerChoice;
    }

    private int generateShopkeeperChoice() {
        Random random = new Random();
        return random.nextInt(3); // 0:グー, 1:チョキ, 2:パー
    }

    private boolean determineWinner(int playerChoice, int shopkeeperChoice) {
        if (playerChoice == shopkeeperChoice) {
            JOptionPane.showMessageDialog(this, "引き分け！");
            return true;
        } else if ((playerChoice == 0 && shopkeeperChoice == 1) ||
                (playerChoice == 1 && shopkeeperChoice == 2) ||
                (playerChoice == 2 && shopkeeperChoice == 0)) {
            JOptionPane.showMessageDialog(this, "勝ちました！一番高いアイテムが無料になります！");
            exitEvent();
            return false;
        } else {
            JOptionPane.showMessageDialog(this, "負けました…");
            // 負けた場合の処理を追加
            exitEvent();
            return false;
        }
    }

    public void exitEvent() {
        // イベント終了時の処理をここに追加
        JOptionPane.showMessageDialog(this, "イベント終了");
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

