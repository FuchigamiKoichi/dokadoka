package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
//HPと状態異常を全回復させる機能を持つクラス
public class King {
    //HPを全回復するメソッド
    public void recover(FightCharacter FC){
        FC.setHP(FC.defaultHP + FC.gainHP);
        FC.health = "健康";
    }
    
    
    //HPの最大値を増やしていきたい
    
    
    public static void main(String[] args) {
        FightCharacter FC = new FightCharacter("John", 0, 0, 0, 0, 100, "毒");
        King king = new King();
        System.out.println("勇者" + FC.getName() + "よ!\n" + "よくぞ戻ったダバ");
        System.out.println("ガンバってるようダバ、" + "まずは、キズついた体を治してあげるダバ!");
        
        king.recover(FC);
    
        System.out.println("キズついた体はきれいに治ったダバ");
        System.out.println( "HP(" + FC.getName() + "): " + FC.HP + "\n健康状態: " + FC.health);
    }
}
