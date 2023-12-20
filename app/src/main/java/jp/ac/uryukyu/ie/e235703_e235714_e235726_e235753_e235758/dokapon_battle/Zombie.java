package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

public class Zombie extends Enemy{
    double ZombieEXP = 130;
    public Zombie(String name,int HP,int SP,int DF,int AT,int MP,int money,String health){
        super(name, HP, SP, DF, AT, MP, money, health);
    }

    public static void main(String[] args) {
        Enemy zombie1 = new Zombie("ゾンビ", 0, 0, 0, 0, 0, 0, "通常");
        zombie1.setObtainedEXP(130);
        
        if(zombie1.HP <= 0){
            zombie1.EnemyDead();
        }
    }

}
