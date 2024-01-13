package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_game;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.Enemy;
import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.Zombie;

public class Skeleton extends Enemy{
    double SkeletonEXP = 130;
    public Skeleton(String name,int HP,int SP,int DF,int AT,int MP,int money,String health){
        super(name, HP, SP, DF, AT, MP, money, health);
    }

    public static void main(String[] args) {
        Enemy skeleton1 = new Zombie("ゾンビ", 0, 0, 0, 0, 0, 0, "通常");
        skeleton1.setObtainedEXP(130);
        
        if(skeleton1.getHP() <= 0){
            skeleton1.EnemyDead();
        }
    }
}
