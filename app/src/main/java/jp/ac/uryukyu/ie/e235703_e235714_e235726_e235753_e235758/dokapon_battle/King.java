package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

//HPと状態異常を全回復させる機能を持つクラス
public class King {
    //HPを全回復するメソッド
    public void recover(FightCharacter FC){
        FC.setHP(FC.defaultHP + FC.gainHP);
        FC.health = "健康";
    }
}
