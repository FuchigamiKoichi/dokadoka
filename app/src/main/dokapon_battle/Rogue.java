package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
//"ローグ"という名前のモンスターを扱うクラス
//スライムぐらいの弱いイメージ
public class Rogue extends Enemy{
    

    public Rogue(String name,int HP,int SP,int DF,int AT,int MP,int money,String health){
        super(name, HP, SP, DF, AT, MP, money, health);
    }



    public static void main(String[] args) {
        Enemy rogue = new Rogue("ローグ", 0, 0, 0, 0, 0, 0,"健康");
        //倒すと経験値が50得られる
        rogue.setObtainedEXP(50);
        if(rogue.HP <= 0){
            rogue.EnemyDead();
        }
    }

}