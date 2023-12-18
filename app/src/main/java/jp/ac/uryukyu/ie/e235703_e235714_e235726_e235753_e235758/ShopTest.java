package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;

import java.util.Scanner;

public class ShopTest {
    public static void main(String[] args) {
        // 商品のリストと在庫を作成
        Item[] items = {
            new Item("アイテム1", 100),
            new Item("アイテム2", 200),
            new Item("アイテム3", 150)
        };
        int[] initialStock = {5, 3, 7};

        // ショップを作成
        Shop shop = new Shop(items, initialStock);

        // プレイヤーを作成
        Player player = new Player(1000, 10);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== ショップ ===");
            shop.displayItems();
            System.out.println("所持金: " + player.getMoney());
            System.out.println("購入する商品番号を選んでください (0: ショップを出る): ");
            choice = scanner.nextInt();

            if (choice != 0) {
                System.out.println("購入する数量を入力してください: ");
                int quantity = scanner.nextInt();
                shop.buyItem(choice - 1, quantity, player);
            }
        } while (choice != 0);
    }
}
