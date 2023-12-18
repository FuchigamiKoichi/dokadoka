package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;


    // 商品を表すクラス
    /*class Item {
        private String name;
        private int price;

        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }*/

    // ショップを管理するクラス
    public class Shop {
        private Item[] items; // ショップで販売する商品リスト
        private int[] stock; // 商品の在庫

        public Shop(Item[] items, int[] initialStock) {
            this.items = items;
            this.stock = initialStock;
        }

        public void displayItems() {
            System.out.println("商品リスト:");
            for (int i = 0; i < items.length; i++) {
                System.out.println(
                        (i + 1) + ". " + items[i].getName() + " - 価格: " + items[i].getPrice() + "  在庫: " + stock[i]);
            }
        }

        public void buyItem(int itemIndex, int quantity, Player player) {
            if (itemIndex >= 0 && itemIndex < items.length && stock[itemIndex] >= quantity) {
                int totalPrice = items[itemIndex].getPrice() * quantity;
                if (player.getMoney() >= totalPrice) {
                    player.decreaseMoney(totalPrice);
                    player.addItem(items[itemIndex], quantity);
                    stock[itemIndex] -= quantity;
                    System.out.println("購入が完了しました！");
                } else {
                    System.out.println("所持金が足りません！");
                }
            } else {
                System.out.println("その商品は購入できません！");
            }
        }

        public void sellItem(int itemIndex, int quantity, Player player) {
            if (itemIndex >= 0 && itemIndex < player.getInventorySize()
                    && player.getItemQuantity(itemIndex) >= quantity) {
                int totalPrice = items[itemIndex].getPrice() * quantity;
                player.increaseMoney(totalPrice);
                player.removeItem(itemIndex, quantity);
                stock[itemIndex] += quantity;
                System.out.println("売却が完了しました！");
            } else {
                System.out.println("その商品は売却できません！");
            }
        }
    }

    // プレイヤーを表すクラス
    /*class Player {
        private int money;
        private Item[] inventory;
        private int[] quantities;

        public Player(int initialMoney, int inventorySize) {
            this.money = initialMoney;
            this.inventory = new Item[inventorySize];
            this.quantities = new int[inventorySize];
        }

        public int getMoney() {
            return money;
        }

        public void decreaseMoney(int amount) {
            money -= amount;
        }

        public void increaseMoney(int amount) {
            money += amount;
        }

        public int getInventorySize() {
            return inventory.length;
        }

        public void addItem(Item item, int quantity) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    quantities[i] = quantity;
                    break;
                } else if (inventory[i].getName().equals(item.getName())) {
                    quantities[i] += quantity;
                    break;
                }
            }
        }

        public void removeItem(int index, int quantity) {
            quantities[index] -= quantity;
            if (quantities[index] <= 0) {
                inventory[index] = null;
                quantities[index] = 0;
            }
        }

        public int getItemQuantity(int index) {
            return quantities[index];
        }
    }*/

