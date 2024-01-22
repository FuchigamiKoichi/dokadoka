package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

public class Item{    
    private String itemName;
    private String function;

    public Item(String name,String function){
        this.itemName = name;
        this.function = function;
    }

    public String getItemName(){
        return this.itemName;
    }

    public String getFunction(){
        return this.function;
    }

    
    public void displayInfo(){
        System.out.println("{アイテム名: " + this.itemName + "}\n{機能: " + this.function + "}");
    }

    public static void main(String[] args) {
        Item item = new Item("青銅の盾","防御力50アップ");
        item.displayInfo();
    }

}
