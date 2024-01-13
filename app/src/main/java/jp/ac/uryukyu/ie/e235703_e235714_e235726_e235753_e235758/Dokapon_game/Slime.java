package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_game;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.Enemy;

public class Slime extends Enemy{
    double slimeEXP = 130;
    public Slime(String name,int HP,int SP,int DF,int AT,int MP,int money,String health){
        super(name, HP, SP, DF, AT, MP, money, health);
    }

    public static void main(String[] args) {
        Enemy slime_1 = new Slime("ゾンビ", 0, 0, 0, 0, 0, 0, "通常");
        slime_1.setObtainedEXP(130);
        
        if(slime_1.getHP() <= 0){
            slime_1.EnemyDead();
        }
    }
}
