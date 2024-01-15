package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
//HPと状態異常を全回復させる機能を持つクラス
//イメージはドラクエの宿屋
public class King {
    //HPを全回復するメソッド
    public void recover(FightCharacter FC){  //FCはFightCharacterの略
        FC.setHP(FC.defaultHP + FC.gainHP);
        FC.health = "健康";
    }
    
    
    public static void main(String[] args) {
        FightCharacter FC = new FightCharacter("John", 0, 0, 0, 0, 100,500, "毒");
        King king = new King();
        //王様の語尾は "ダバ" (重要)
        System.out.println("勇者" + FC.getName() + "よ!\n" + "よくぞ戻ったダバ");
        System.out.println("ガンバってるようダバ、" + "まずは、キズついた体を治してあげるダバ!");
        
        king.recover(FC);
    
        System.out.println("キズついた体はきれいに治ったダバ");
        System.out.println( "HP(" + FC.getName() + "): " + FC.HP + "\n健康状態: " + FC.health);
    }
}
