package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;

// 商品を表すクラス
public class Item {
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
}
