package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;

// プレイヤーを表すクラス
public class Player {
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
    }


