package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

//"ゾンビ"という名前のモンスターを扱うクラス
//結構強めの中ボスくらいのイメージ
public class Zombie extends Enemy{
    //強いので多めに経験値を得られる
    double ZombieEXP = 130;
    public Zombie(String name,int HP,int SP,int DF,int AT,int MP,int money,String health){
        super(name, HP, SP, DF, AT, MP, money, health);
    }

    public static void main(String[] args) {
        Enemy zombie1 = new Zombie("ゾンビ", 0, 0, 0, 0, 0, 0, "通常");
        //倒すと経験値が130得られる
        zombie1.setObtainedEXP(130);
        
        if(zombie1.HP <= 0){
            zombie1.EnemyDead();
        }
    }

}
